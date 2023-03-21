package com.tel.Repository;

import com.tel.Entity.BroadBandSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BroadbandSubscribeRepo extends JpaRepository<BroadBandSubscription, Long>{
	List<BroadBandSubscription> findAllByUserId(Long userId);

}
