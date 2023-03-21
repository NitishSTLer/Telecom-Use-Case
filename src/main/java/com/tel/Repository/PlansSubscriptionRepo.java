package com.tel.Repository;

import com.tel.Entity.PlanSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlansSubscriptionRepo extends JpaRepository<PlanSubscription, Long> {
	
	List<PlanSubscription> findAllByUserId(Long userId);

}
