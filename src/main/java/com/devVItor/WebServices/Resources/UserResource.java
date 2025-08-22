package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1,"maria","MAria@gmail.com","000000000","00000000");
        return ResponseEntity.ok().body(u);
    }


}
