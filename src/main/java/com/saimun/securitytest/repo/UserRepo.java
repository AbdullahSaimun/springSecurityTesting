package com.saimun.securitytest.repo;

import com.saimun.securitytest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
}
