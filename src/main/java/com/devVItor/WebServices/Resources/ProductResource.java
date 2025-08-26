package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.Product;
import com.devVItor.WebServices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("value = products")
public class ProductResource {

    @Autowired
    private ProductService ps;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> p = ps.findAll();
        return ResponseEntity.ok().body(p);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product p = ps.findById(id);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product p2 = ps.create(product);

        return ResponseEntity.ok().body(p2);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Product> update(@RequestBody Product p) {
        Product p3 = ps.update(p);

        return ResponseEntity.ok().body(p3);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(ps.delete(id));
    }
}
