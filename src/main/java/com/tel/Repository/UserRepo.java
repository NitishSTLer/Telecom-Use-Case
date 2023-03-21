package com.tel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tel.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Long>{
	
	User findFirstByEmail(String email);

}
