package com.tel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tel.Entity.BroadBand;


@Repository
public interface BroadBandRepo extends JpaRepository<BroadBand, Long> {
	
	

}
