package com.tel.services.customer;

import com.tel.DTO.*;
import com.tel.Entity.*;
import com.tel.Repository.*;
import com.tel.Response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl  implements CustomerService{


    @Autowired
    private PlansSubscriptionRepo  plansSubscriptionRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private BroadBandRepo broadBandRepo;

    @Autowired
    private BroadbandSubscribeRepo broadbandSubscribeRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public GeneralResponse postPlan(PlanDto planDto) {
        GeneralResponse response = new GeneralResponse();
        Plan plan = new Plan();
        plan.setName((String) planDto.getName());
        plan.setCost(planDto.getCost());
        plan.setDuration(planDto.getDuration());
        plan.setCreationDate(new Date());
        plan.setIsActive(Boolean.TRUE);
        plansRepo.save(plan);
        response.setMessage("Plan saved SuccessFully");
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

    @Override
    public GeneralResponse postBroadBand(BroadbandDto broadbandDto) {
        GeneralResponse response = new GeneralResponse();
        BroadBand broadBand = new BroadBand();
        broadBand.setName(broadbandDto.getName());
        broadBand.setCost(broadbandDto.getCost());
        broadBand.setDuration(broadbandDto.getDuration());
        broadBand.setCreationDate(new Date());
        broadBand.setIsActive(Boolean.TRUE);
        broadBand.setIsDeleted(Boolean.FALSE);
        broadBandRepo.save(broadBand);
        response.setMessage("Broadband Saved Successfully");
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

    @Override
    public List<PlanDto> getAllPlans() {
        return plansRepo.findAll().stream().map(Plan::getPlansDto).collect(Collectors.toList());
    }

    @Override
    public List<BroadbandDto> getAllBroadBands() {
        return broadBandRepo.findAll().stream().map(BroadBand::getBroadbandDto).collect(Collectors.toList());
    }

    @Override
    public PlanDto getPlanById(Long planId) {
        PlanDto planDto = null;
        Optional<Plan> optionalPlan = plansRepo.findById(planId);
        if(optionalPlan.isPresent()){
            planDto = optionalPlan.get().getPlansDto();
        }
        return planDto;
    }

    @Override
    public BroadbandDto getBroadBandById(Long broadbandId) {
        BroadbandDto broadbandDto = null;
        Optional<BroadBand> optionalBroadBand = broadBandRepo.findById(broadbandId);
        if(optionalBroadBand.isPresent()){
            broadbandDto = optionalBroadBand.get().getBroadbandDto();
        }
        return broadbandDto;
    }

    @Override
    public GeneralResponse subscribePlan(PlanSubscriptionDto planSubscriptionDto, Long planId) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findById(planSubscriptionDto.getUserId());
        Optional<Plan> optionalPlan = plansRepo.findById(planId);
        if(optionalUser.isPresent() && optionalPlan.isPresent()){
            PlanSubscription planSubscription = new PlanSubscription();
            planSubscription.setPhoneNumber(planSubscriptionDto.getPhoneNumber());
            planSubscription.setCreatedDate(new Date());
            planSubscription.setExpireAt(planSubscriptionDto.getExpireAt());
            planSubscription.setPlan(optionalPlan.get());
            planSubscription.setUser(optionalUser.get());
            plansSubscriptionRepo.save(planSubscription);
            response.setMessage("Plan Subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);

        }else {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("User or Plan Not Found");
        }
        return response;
    }

    @Override
    public GeneralResponse subscribeBroadband(BroadBandSubscribeDto broadBandSubscribeDto, Long broadBandId) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findById(broadBandSubscribeDto.getId());
        Optional<BroadBand> optionalBroadBand = broadBandRepo.findById(broadBandId);
        if(optionalUser.isPresent() && optionalBroadBand.isPresent()){
            BroadBandSubscription broadBandSubscription = new BroadBandSubscription();
            broadBandSubscription.setPhoneNumber(broadBandSubscribeDto.getPhoneNumber());
            broadBandSubscription.setCreatedDate(new Date());
            broadBandSubscription.setExpireAt(broadBandSubscribeDto.getExpireAt());
            broadBandSubscription.setBroadband(optionalBroadBand.get());
            broadbandSubscribeRepo.save(broadBandSubscription);
            response.setMessage("BroadBand Subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);
        }else{
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("User or Broadband not Found");
        }
        return response;
    }

    @Override
    public List<PlanSubscriptionDto> getAllSubscribedPlans(Long userId) {
        return plansSubscriptionRepo.findAllByUserId(userId).stream().map(PlanSubscription::getPlanSubscriptionDto).collect(Collectors.toList());
    }

    @Override
    public List<BroadBandSubscribeDto> getAllSubscribedBroadBand(Long userId) {
        return broadbandSubscribeRepo.findAllByUserId(userId).stream().map(BroadBandSubscription::getSubscriptionBroadbandDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getProfileByUserId(Long userId) {
        UserDto userDto = null;
        Optional<User> optionalUser =userRepo.findById(userId);
        if(optionalUser.isPresent()){
            userDto = optionalUser.get().getUserDto();
        }
        return userDto;
    }

    @Override
    public GeneralResponse updateCustomerProfile(UserDto userDto, Long userId) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setEmail(userDto.getEmail());
            userRepo.save(user);
            response.setMessage("User Updated Successfully");
            response.setStatus(HttpStatus.OK);

        }else {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("User Not Found");
        }
        return response;
    }

    @Override
    public List<PlanDto> getAllPlansForGuest() {
        return  plansRepo.findAll().stream().map(Plan::getPlansDto).collect(Collectors.toList());
    }

    @Override
    public List<BroadbandDto> getAllBroadBandsForGuest() {
        return broadBandRepo.findAll().stream().map(BroadBand::getBroadbandDto).collect(Collectors.toList());
    }
}
