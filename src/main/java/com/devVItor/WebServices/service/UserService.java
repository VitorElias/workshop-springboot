package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public List<User> findAll() {return ur.findAll();}

    public User findById(Long id){
        Optional<User> u  = ur.findById(id);
        return u.get();
    }

    public User create(User user) {
        ur.save(user);
        return user;
    }

    public void Update(User user) {ur.save(user);}

    public void Delete(long Id) {ur.deleteById(Id);}
}
