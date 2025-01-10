package com.test03.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.test03.test.repository.LoginTableRepository;
import com.test03.test.repository.UserRepository;

@AutoConfigureDataJpa
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	 @Autowired
	 private LoginTableRepository loginTableRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("sushilshrestha7@gmail.com");
		user.setPassword("sushil@563");
		user.setFirstName("Sushil");
		user.setLastName("Shrestha");
		
		User savedUser= repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
		
		
		@Test
		public void testAddUser() {
		
		// Validate LoginTable entry
        LoginTable loginTable = new LoginTable();
        loginTable.setEmail("sushilshrestha7@gmail.com");
        loginTable.setPassword("sushil@563");
        
        LoginTable savedLoginTable= loginTableRepository.save(loginTable);
        
        LoginTable existLoginTable= entityManager.find(LoginTable.class, savedLoginTable.getId());
        
        assertThat(existLoginTable.getEmail()).isEqualTo(loginTable.getEmail());
        
        

	}
	
	

}
