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
import com.tel.DTO.GuestBroadBandSubscriptionDto;

import lombok.Data;

@Data
@Entity
public class GuestBroadBandSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String phoneNumber;
	private Date createdDate;
	private Date expireAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "broadband_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private BroadBand broadBand;
	
	
	public GuestBroadBandSubscriptionDto getGuestbroadBandSubscriptionDto() {
		GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto = new GuestBroadBandSubscriptionDto();
		guestBroadBandSubscriptionDto.setId(id);
		guestBroadBandSubscriptionDto.setPhoneNumber(phoneNumber);
		guestBroadBandSubscriptionDto.setCreatedDate(createdDate);
		guestBroadBandSubscriptionDto.setExpireAt(expireAt);
		guestBroadBandSubscriptionDto.setBroadbandId(broadBand.getId());
		guestBroadBandSubscriptionDto.setBroadbandCost(broadBand.getCost());
		guestBroadBandSubscriptionDto.setBroadbandDuration(broadBand.getDuration());
		
	
		return guestBroadBandSubscriptionDto;
		
	}

}
