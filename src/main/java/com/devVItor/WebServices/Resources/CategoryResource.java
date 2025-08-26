package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.Category;
import com.devVItor.WebServices.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryResource {

    @Autowired
    private CategoryService cs;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(cs.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(cs.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> create(@RequestBody Category cat){
        return ResponseEntity.ok().body(cs.create(cat));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Category> update(@RequestBody Category cat) {
        return ResponseEntity.ok().body(cs.update(cat));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(cs.delete(id));
    }
}
