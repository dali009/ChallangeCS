package com.example.demo.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.user;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.entities.Role;
import com.example.demo.dao.RoleRepository;

@Service
@Slf4j
public class UserService implements UserDetailsService   {

	private final UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	RoleRepository RoleRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		user user = userRepository.findUserWithName(username)
		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	return (UserDetails) user;

}
	

	public user saveUser(String username, String password, String confirmedPassword) {
		user appUser = new user();
		if (userRepository.findUserWithName(username).isPresent() == true)
		throw new RuntimeException("User already exists");
		if (!password.equals(confirmedPassword))
		throw new RuntimeException("Please confirm your password");
		appUser.setUsername(username);
		Set<Role> roles = new HashSet<Role>();
		Role r = new Role(null, "ROLE_USER");
		RoleRepository.save(r);
		roles.add(r);
		appUser.setRoles(roles);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(appUser);
		return appUser;
		}
}
