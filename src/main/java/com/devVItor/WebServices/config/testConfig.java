package com.devVItor.WebServices.config;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Maria Brown","Maria@gmail.com","9333333","123456");
        User u2 = new User("Mario","mario@gmail.com","9222222","123456");

        userRepository.save(u1);
        userRepository.save(u2);
    }
}
