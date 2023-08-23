package com.springboot.firstRESTapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetails, Integer>{
	List<UserDetails> findByRole (String role);

}
