package com.saimun.securitytest.service;

import com.saimun.securitytest.model.Users;
import com.saimun.securitytest.repo.UserRepo;
import com.saimun.securitytest.user.UserPrinciple;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDetailsService implements UserDetailsService {

	private final UserRepo userRepo;

	public MyDetailsService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByUsername(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException(("User not found"));
		}
		return new UserPrinciple(user);
	}
}
