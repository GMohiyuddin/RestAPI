package com.springboot.firstRESTapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailRestRepository extends PagingAndSortingRepository<UserDetails, Integer>{
	List<UserDetails> findByRole (String role);

}
