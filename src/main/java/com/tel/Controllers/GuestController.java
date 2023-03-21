package com.tel.Controllers;

import com.tel.DTO.GuestBroadBandSubscriptionDto;
import com.tel.DTO.GuestPlanSubscriptionDto;
import com.tel.Response.GeneralResponse;
import com.tel.services.guest.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/guest/")
@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("plans")
    public GeneralResponse getAllPlansForGuest(){
        GeneralResponse response = new GeneralResponse();
        try{
            response.setData(guestService.getAllPlansForGuest());
            response.setMessage("Sorry Something Went Wrong.");

        }catch (Exception ex){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went wrong");
        }
        return response;

    }

    @GetMapping("broadBands")
    public GeneralResponse getAllBroadBandForGuest(){
        GeneralResponse response = new GeneralResponse();
        try{
            response.setData(guestService.getAllBroadBandsForGuest());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("BroadBand Fetched Successfully!!!");
        }catch (Exception ex){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;
    }

    @GetMapping("plan/{planId}")
    public GeneralResponse getPlanById(@PathVariable Long planId){
        GeneralResponse response = new GeneralResponse();
        try{
            response.setData(guestService.getPlanById(planId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");


        }catch (Exception ex){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;
    }

    @GetMapping("broadBand/{broadbandId}")
    public GeneralResponse getBroadBandId(@PathVariable Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(guestService.getBroadBandById(broadbandId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");


        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;
    }

    @PostMapping("subscribe-plan/{planId}")
    public GeneralResponse SubscribePlan(@RequestBody GuestPlanSubscriptionDto guestPlanSubscriptionDto, @PathVariable Long planId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return guestService.subscribePlan(guestPlanSubscriptionDto,planId);
        }catch (Exception ex){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }

        return response;

    }

    @PostMapping("subscribe-broadband/{broadbandId}")
    public GeneralResponse subscribeBroadBand(@RequestBody GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto, @PathVariable Long broadBandId){
        GeneralResponse response = new GeneralResponse();
        try {
            return guestService.subscribeBroadband(guestBroadBandSubscriptionDto,broadBandId);
        }catch (Exception ex){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;
    }
}
