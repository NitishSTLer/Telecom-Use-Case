package com.tel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tel.Entity.Plan;
import org.springframework.stereotype.Repository;

@Repository
public interface  PlansRepo extends JpaRepository<Plan, Long> {

}
