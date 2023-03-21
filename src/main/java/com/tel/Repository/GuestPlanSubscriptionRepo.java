package com.tel.Repository;

import com.tel.Entity.GuestPlanSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestPlanSubscriptionRepo extends JpaRepository<GuestPlanSubscription, Long>{

}
