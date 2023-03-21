package com.tel.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tel.DTO.GuestPlanSubscriptionDto;

import lombok.Data;


@Entity
@Data
public class GuestPlanSubscription {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Long id;
	
	private String phoneNumber;
	
	private Date createdDate;
	
	private Date expireAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "plan_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Plan plan;
	
	public GuestPlanSubscriptionDto getGuestPlanSubscriptionDto() {
		GuestPlanSubscriptionDto guestPlanSubscriptionDto = new GuestPlanSubscriptionDto();
		guestPlanSubscriptionDto.setId(id);
		guestPlanSubscriptionDto.setPhoneNumber(phoneNumber);
		guestPlanSubscriptionDto.setCreatedDate(createdDate);
		guestPlanSubscriptionDto.setExpireAt(expireAt);
		guestPlanSubscriptionDto.setPlanId(plan.getId());
		guestPlanSubscriptionDto.setPlanCost(plan.getCost());
		guestPlanSubscriptionDto.setDuration(plan.getDuration());
		
		return guestPlanSubscriptionDto;
		
	}
	
	
	

}
