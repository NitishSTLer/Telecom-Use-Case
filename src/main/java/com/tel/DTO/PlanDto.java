package com.tel.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PlanDto {
	
	private Long id;
	private String name ;
	private Float cost;
	private Long duration;
	private Date creationDate;
	private Boolean isActive;
	private Boolean IsDeleted;
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
