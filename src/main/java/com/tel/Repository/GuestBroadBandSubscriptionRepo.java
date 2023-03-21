package com.tel.Repository;

import com.tel.Entity.GuestBroadBandSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBroadBandSubscriptionRepo extends JpaRepository<GuestBroadBandSubscription, Long> {

}
