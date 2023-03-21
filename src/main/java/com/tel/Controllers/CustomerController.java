package com.tel.Controllers;

import com.tel.DTO.*;
import com.tel.Response.GeneralResponse;
import com.tel.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("plan")
    public GeneralResponse postPlan(@RequestBody PlanDto planDto) {
        GeneralResponse response = new GeneralResponse();

        try {
            return customerService.postPlan(planDto);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;

    }

    @PostMapping("broadband")
    public GeneralResponse postBroadband(@RequestBody BroadbandDto broadbandDto) {
        GeneralResponse response = new GeneralResponse();

        try {
            return customerService.postBroadBand(broadbandDto);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Something Went wrong");
        }
        return response;
    }

    @GetMapping("plans")
    public GeneralResponse getAllPlans() {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getAllPlans());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }

    @GetMapping("broadBands")
    public GeneralResponse getAllBroadBands() {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getAllBroadBands());
            response.setStatus(HttpStatus.OK);
            response.setMessage("BroadBands Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong");
        }
        return response;

    }

    @GetMapping("plan/{planId}")
    public GeneralResponse getPlanById(@PathVariable Long planId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getPlanById(planId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }

    @GetMapping("broadBand/{broadbandId}")
    public GeneralResponse getBroadBandById(@PathVariable Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getBroadBandById(broadbandId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;

    }

    @PostMapping("subscribe-plan/{planId}")
    public GeneralResponse subscribePlan(@RequestBody PlanSubscriptionDto planSubscriptionDto, @PathVariable Long planId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return customerService.subscribePlan(planSubscriptionDto, planId);

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }
    @PostMapping("subscribe-broadband/{broadbandId}")
    public GeneralResponse subscribeBroadband(@RequestBody BroadBandSubscribeDto broadBandSubscribeDto ,@PathVariable Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return customerService.subscribeBroadband(broadBandSubscribeDto, broadbandId);

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }
    @GetMapping("/subscribed-plans/{userId}")
    public GeneralResponse getAllSubscribedPlans(@PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getAllSubscribedPlans(userId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }
    @GetMapping("/subscribed-broadBands/{userId}")
    public GeneralResponse getAllSubscribedBroadBand(@PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getAllSubscribedBroadBand(userId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }
    @GetMapping("/profile/{userId}")
    public GeneralResponse getProfileByUserId(@PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(customerService.getAllSubscribedBroadBand(userId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
        }
        return response;
    }
    @PutMapping("update-customer/{userId}")
    public GeneralResponse updateCustomerProfile(@PathVariable UserDto userDto,@PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
           return customerService.updateCustomerProfile(userDto, userId);

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Went Wrong.");
            return response;
        }

    }
}
