package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService us;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> list = us.findAll();

        return ResponseEntity.ok().body(list);


    }


}
