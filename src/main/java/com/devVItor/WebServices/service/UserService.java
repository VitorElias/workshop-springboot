package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.User;
import com.devVItor.WebServices.Repository.UserRepository;
import com.devVItor.WebServices.service.exceptions.DatabaseException;
import com.devVItor.WebServices.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return u.orElseThrow(() -> new ResourceNotFoundException(id)) ;
    }

    public User create(User user) {
        ur.save(user);
        return user;
    }

    public User Update(Long id, User obj) {

        try {
            User entidade = ur.getReferenceById(id);
            updateData(entidade, obj);
            return ur.save(entidade);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void Delete(Long Id) {
        try {
            ur.deleteById(Id);
        }catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(Id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(User entidade, User obj){
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
    }
}
