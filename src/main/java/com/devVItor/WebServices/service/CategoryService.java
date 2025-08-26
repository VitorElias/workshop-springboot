package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.Category;
import com.devVItor.WebServices.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository cr;

    public List<Category> findAll() {
        return cr.findAll();
    }

    public Category findById(long id) {

        Optional<Category> c = cr.findById(id);

        return c.get();
    }

    public Category create(Category c) {
        return cr.save(c);
    }
    public Category update(Category c) {
        return cr.save(c);
    }

    public String delete(Long id) {

        if(cr.existsById(id)){

            cr.deleteById(id);
            return "A categoria foi deletada!";
        }
        return "A categoria não foi deletada!";
    }
}
