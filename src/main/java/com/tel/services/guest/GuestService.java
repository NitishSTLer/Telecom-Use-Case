package com.tel.services.guest;

import com.tel.DTO.BroadbandDto;
import com.tel.DTO.GuestBroadBandSubscriptionDto;
import com.tel.DTO.GuestPlanSubscriptionDto;
import com.tel.DTO.PlanDto;
import com.tel.Response.GeneralResponse;

import java.util.List;

public interface GuestService {


    List<Object> getAllPlansForGuest();

    List<BroadbandDto> getAllBroadBandsForGuest();

    PlanDto getPlanById(Long planId);


    BroadbandDto getBroadBandById(Long broadbandId);


    GeneralResponse subscribePlan(GuestPlanSubscriptionDto guestPlanSubscriptionDto, Long planId);

    GeneralResponse subscribeBroadband(GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto, Long broadbandId);

}
