package com.tel.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class GuestBroadBandSubscriptionDto {
	
	private Long id;
	private String phoneNumber;
	private Date createdDate;
	private Date expireAt;
	private Long broadbandId;
	private Float broadbandCost;
	private Long broadbandDuration;
	
	
	

}
