package com.tel.Entity;

import java.util.Date;



import com.tel.DTO.PlanSubscriptionDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="plan_subscription")
@Data
public class PlanSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String phoneNumber;
	
	private Date createdDate;
	
	private Date expireAt;

//	private String PlanId;
//
//	private String PlanName;
//
//	private Float PlanCost;
//
//	private Long duration;
//
//	private Long UserId;
//
//	private String username;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "plan_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Plan plan;
	
	
	public PlanSubscriptionDto getPlanSubscriptionDto() {
		PlanSubscriptionDto planSubscriptionDto = new PlanSubscriptionDto();
		planSubscriptionDto.setId(id);
		planSubscriptionDto.setPhoneNumber(phoneNumber);
		planSubscriptionDto.setCreatedDate(createdDate);
		planSubscriptionDto.setExpireAt(expireAt);
		planSubscriptionDto.setPlanId(plan.getId());
		planSubscriptionDto.setPlanName(plan.getName());
		planSubscriptionDto.setPlanCost(plan.getCost());
		planSubscriptionDto.setDuration(plan.getDuration());
		planSubscriptionDto.setUserId(user.getId());
		planSubscriptionDto.setUsername(user.getName());
		return planSubscriptionDto;
	}

}
