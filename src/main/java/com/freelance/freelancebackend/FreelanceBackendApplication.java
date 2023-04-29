package com.freelance.freelancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.freelance.freelancebackend.entity.Role;
import com.freelance.freelancebackend.repository.RoleRepository;
import com.freelance.freelancebackend.security.SecurityConstants;

@SpringBootApplication
public class FreelanceBackendApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FreelanceBackendApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("USER"));
		Role adminRole = roleRepository.findById(SecurityConstants.ROLE_ADMIN_ID).get();
		Role userRole = roleRepository.findById(SecurityConstants.ROLE_USER_ID).get();


		roleRepository.save(adminRole);
		roleRepository.save(userRole);

	}

}
