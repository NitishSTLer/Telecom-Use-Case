package com.tel.services.customer;



import com.tel.DTO.*;
import com.tel.Response.GeneralResponse;

import java.util.List;

public interface CustomerService {

    GeneralResponse postPlan(PlanDto planDto);

    GeneralResponse postBroadBand(BroadbandDto broadbandDto);

    List<PlanDto> getAllPlans();

    List<BroadbandDto> getAllBroadBands();


    PlanDto getPlanById(Long planId);

    BroadbandDto getBroadBandById(Long broadbandId);

    GeneralResponse subscribePlan(PlanSubscriptionDto planSubscriptionDto,Long planId);

    GeneralResponse subscribeBroadband(BroadBandSubscribeDto broadBandSubscribeDto,Long broadBandId);

    List<PlanSubscriptionDto> getAllSubscribedPlans(Long userId);

    List<BroadBandSubscribeDto> getAllSubscribedBroadBand(Long userId);

    UserDto getProfileByUserId(Long userId);

    GeneralResponse updateCustomerProfile(UserDto userDto,Long userId);

    List<PlanDto> getAllPlansForGuest();

    List<BroadbandDto> getAllBroadBandsForGuest();


}
