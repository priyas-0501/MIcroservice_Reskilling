package com.ibm.poc.config.security;

import java.security.Principal;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.poc.db.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepo;

	public UserDetailsServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

		return this.userRepo.findByLoginId(loginId)
				.map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("LoginId: " + loginId + " not found"));
	}

}
