package com.saimun.securitytest.user;

import com.saimun.securitytest.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrinciple implements UserDetails {

	private final Users user;

	public UserPrinciple(Users user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Return user roles or authorities here (e.g., from a roles field in your Users class)
		return null;  // For now, returning null; you should return actual authorities if using roles.
	}

	@Override
	public String getPassword() {
		return user.getPassword();  // Use the password field from Users entity
	}

	@Override
	public String getUsername() {
		return user.getUsername();  // Use the username field from Users entity
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;  // You can customize this based on your user entity
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;  // Customize if you have a locked field
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;  // Customize if you have credential expiration logic
	}

	@Override
	public boolean isEnabled() {
		return true;  // Customize if you have an "enabled" field in your user entity
	}
}
