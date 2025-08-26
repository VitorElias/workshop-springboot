package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        URI iri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(userCreated.getId()).
                toUri();

        return ResponseEntity.created(iri).body(userCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id ,@RequestBody User user){

        return ResponseEntity.ok().body(us.Update(id,user));

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        us.Delete(id);

        return ResponseEntity.noContent().build();
    }





}
