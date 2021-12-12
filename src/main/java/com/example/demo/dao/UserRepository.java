package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entities.user;


public interface UserRepository extends JpaRepository<user,Integer> {
	@Query(" select u from User u where u.username = ?1")
	Optional<user> findUserWithName(String username);
}
