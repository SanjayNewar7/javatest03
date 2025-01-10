package com.test03.test.Service;

import com.test03.test.LoginTable;
import com.test03.test.User;
import com.test03.test.repository.LoginTableRepository;
import com.test03.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginTableRepository loginTableRepository;

    public User saveUserAndLoginTable(User user) {
        // Save user into User table
        User savedUser = userRepository.save(user);

        // Save user credentials into LoginTable
        LoginTable loginTable = new LoginTable();
        loginTable.setEmail(user.getEmail());
        loginTable.setPassword(user.getPassword());
        loginTableRepository.save(loginTable);

        return savedUser;
    }
}
