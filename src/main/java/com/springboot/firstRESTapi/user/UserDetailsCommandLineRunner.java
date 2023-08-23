package com.springboot.firstRESTapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private UserDetailRepository repository; 

	public UserDetailsCommandLineRunner(UserDetailRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(Arrays.toString(args));
		
		repository.save(new UserDetails("munif", "Admin"));
		repository.save(new UserDetails("delawala", "Admin"));
		repository.save(new UserDetails("azaz", "User"));
		
//		List<UserDetails> users = repository.findAll();
		
		List<UserDetails> users = repository.findByRole("Admin");
		users.forEach(user -> logger.info(user.toString()));
		
	}

}
