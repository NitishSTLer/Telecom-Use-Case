package com.tel.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tel.DTO.BroadbandDto;

import lombok.Data;

@Data
@Entity
public class BroadBand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String name;
	
	private Float cost;
	
	private Long duration;
	
	private Date creationDate;
	
	private Boolean isActive;
	
	private Boolean isDeleted;
	
	public BroadbandDto getBroadbandDto() {
		
		BroadbandDto broadbandDto = new BroadbandDto();
		broadbandDto.setId(id);
		broadbandDto.setName(name);
		broadbandDto.setCost(cost);
		broadbandDto.setCreationDate(creationDate);
		broadbandDto.setIsActive(isActive);
		broadbandDto.setIsDeleted(isDeleted);
		return broadbandDto;
		
	}
}
	
	
	

