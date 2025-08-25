package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User obj = us.findById(id);

        return ResponseEntity.ok().body(obj);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User userCreated = us.create(user);

        return ResponseEntity.ok().body(userCreated);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateUser(@RequestBody User user){

        us.Update(user);

        return ResponseEntity.ok().body("Usuario atualizado com sucesso! ");

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        us.Delete(id);

        return ResponseEntity.ok().body("DEU TUDO CERTO!");
    }





}
