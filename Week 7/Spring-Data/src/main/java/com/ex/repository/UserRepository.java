package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ex.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByUsernameLikeIgnoreCase(String username);
	
	@Query("SELECT u FROM USER u WHERE length(u.password)<2")
	public User oddQuery();

}
