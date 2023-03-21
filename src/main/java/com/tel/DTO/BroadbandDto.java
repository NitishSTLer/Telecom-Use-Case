package com.tel.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class BroadbandDto {
	
	private Long id;
	private String name;
	private Float cost;
	private Long duration;
	private Date creationDate;
	private Boolean isActive;
	private Boolean isDeleted;
	
	

}
