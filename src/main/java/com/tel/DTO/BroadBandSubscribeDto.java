package com.tel.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class BroadBandSubscribeDto {
	
	private Long id;
	private String phoneNumber;
	private Date createdDate;
	private Date expireAt;
	private Long userId;
	private String username;
	private Long broadbandId;
	private String broadbandName;
	private Float broadbandCost;
	private Long broadbandDuration;
	

}
