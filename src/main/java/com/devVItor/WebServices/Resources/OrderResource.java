package com.devVItor.WebServices.Resources;

import com.devVItor.WebServices.Model.Order;
import com.devVItor.WebServices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderResource {

    @Autowired
    private OrderService os;


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Order>> findAll(){

        List<Order> ors = os.findAll();

        return ResponseEntity.ok().body(ors);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {

        Order or = os.findById(id);

        return ResponseEntity.ok().body(or);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Order> create(@RequestBody Order or) {

        if(or != null) {
            os.Create(or);
            return ResponseEntity.ok().body(or);
        }
        return null;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Order> update(@RequestBody Order od) {

        os.Update(od);

        return ResponseEntity.ok().body(od);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        String os2 = os.delete(id);

        return ResponseEntity.ok().body(os2);
    }
}
