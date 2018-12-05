package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ex.beans.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameLikeIgnoreCase(String username);
	
	@Query("SELECT u FROM User u WHERE length(u.password)<2")
	public List<User> oddQuery();

}
