package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.Product;
import com.devVItor.WebServices.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public List<Product> findAll() {
        return pr.findAll();
    }

    public Product findById(long id) {

        Optional<Product> p = pr.findById(id);

        return p.get();
    }

    public Product create(Product p) {
        return pr.save(p);
    }

    public Product update(Product p) {
        return pr.save(p);
    }

    public String delete(long id) {

        if(pr.existsById(id)){
            pr.deleteById(id);
            return "O produto foi deletado!";
        }
        return "O produto não foi encontrado!";

    }

}
