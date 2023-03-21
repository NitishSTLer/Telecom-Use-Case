package com.tel.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tel.DTO.BroadBandSubscribeDto;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class BroadBandSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String phoneNumber;
	
	private Date createdDate;
	
	private Date expireAt;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	
	
	private User user;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "broadband_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private BroadBand broadband;
	
	
	public BroadBandSubscribeDto getSubscriptionBroadbandDto() {
		
		BroadBandSubscribeDto broadbandSubscribeDto = new BroadBandSubscribeDto();
		
		broadbandSubscribeDto.setId(id);
		broadbandSubscribeDto.setPhoneNumber(phoneNumber);
		broadbandSubscribeDto.setCreatedDate(createdDate);
		broadbandSubscribeDto.setExpireAt(expireAt);
		broadbandSubscribeDto.setBroadbandId(broadband.getId());
		broadbandSubscribeDto.setBroadbandName(broadband.getName());
		broadbandSubscribeDto.setBroadbandCost(broadband.getCost());
		broadbandSubscribeDto.setBroadbandDuration(broadband.getDuration());
		broadbandSubscribeDto.setUserId(user.getId());
		broadbandSubscribeDto.setUsername(user.getName());
		return broadbandSubscribeDto;
		
	}
	

}
