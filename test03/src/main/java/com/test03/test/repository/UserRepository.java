package com.test03.test.repository;

import com.test03.test.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email); // To find users by email, useful for authentication
}
