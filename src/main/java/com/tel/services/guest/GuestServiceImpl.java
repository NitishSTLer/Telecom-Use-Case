package com.tel.services.guest;

import com.tel.DTO.BroadbandDto;
import com.tel.DTO.GuestBroadBandSubscriptionDto;
import com.tel.DTO.GuestPlanSubscriptionDto;
import com.tel.DTO.PlanDto;
import com.tel.Entity.BroadBand;
import com.tel.Entity.GuestBroadBandSubscription;
import com.tel.Entity.GuestPlanSubscription;
import com.tel.Entity.Plan;
import com.tel.Repository.BroadBandRepo;
import com.tel.Repository.GuestBroadBandSubscriptionRepo;
import com.tel.Repository.GuestPlanSubscriptionRepo;
import com.tel.Repository.PlansRepo;
import com.tel.Response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestBroadBandSubscriptionRepo guestbroadBandSubscriptionRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private BroadBandRepo broadBandRepo;


    @Autowired
    private GuestPlanSubscriptionRepo guestPlanSubscriptionRepo;



    @Override
    public List<Object> getAllPlansForGuest() {
        return plansRepo.findAll().stream().map(Plan::getPlansDto).collect(Collectors.toList());

    }

    @Override
    public List<BroadbandDto> getAllBroadBandsForGuest() {
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
        if (optionalBroadBand.isPresent()){
            broadbandDto = optionalBroadBand.get().getBroadbandDto();
        }
        return broadbandDto;
    }


    @Override
    public GeneralResponse subscribePlan(GuestPlanSubscriptionDto guestPlanSubscriptionDto, Long planId) {
        GeneralResponse response = new GeneralResponse();
        Optional<Plan> optionalPlan = plansRepo.findById(planId);
        if(optionalPlan.isPresent()){
            GuestPlanSubscription guestPlanSubscription = new GuestPlanSubscription();
            guestPlanSubscription.setPhoneNumber(guestPlanSubscriptionDto.getPhoneNumber());
            guestPlanSubscription.setCreatedDate(new Date());
            guestPlanSubscription.setExpireAt(guestPlanSubscriptionDto.getExpireAt());
            guestPlanSubscription.setPlan(optionalPlan.get());
            guestPlanSubscriptionRepo.save(guestPlanSubscription);
            response.setMessage("Plan subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);
        }
        else{
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("Plan not found");
        }
        return response;
    }


    @Override
    public GeneralResponse subscribeBroadband(GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto, Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        Optional<BroadBand> optionalBroadBand = broadBandRepo.findById(broadbandId);
        if (optionalBroadBand.isPresent()) {
            GuestBroadBandSubscription guestBroadBandSubscription = new GuestBroadBandSubscription();
            guestBroadBandSubscription.setPhoneNumber(guestBroadBandSubscription.getPhoneNumber());
            guestBroadBandSubscription.setCreatedDate(new Date());
            guestBroadBandSubscription.setExpireAt(guestBroadBandSubscriptionDto.getExpireAt());
            guestBroadBandSubscription.setBroadBand(optionalBroadBand.get());
            guestbroadBandSubscriptionRepo.save(guestBroadBandSubscription);
            response.setMessage("Plan subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);
        } else {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("Plan not found");
        }
        return response;
    }
}

