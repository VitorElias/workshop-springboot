package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public List<User> findAll() {

        return ur.findAll();

    }

}
