package com.devVItor.WebServices.service;

import com.devVItor.WebServices.Model.Order;
import com.devVItor.WebServices.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id) {

        Optional<Order> or = orderRepository.findById(id);

        if(or.isEmpty()){
            return null;
        }else{

            return or.get();
        }
    }

    public List<Order> findAll(){return orderRepository.findAll();}

    public Order Create(Order or){return orderRepository.save(or);}

    public Order Update(Order or){

        if(or.getId() == null && or.getId() == 0){
            return null;
        }
        return orderRepository.save(or);
    }

    public String delete(long id) {

        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return "O usuario com o id "+id+" foi deletado com sucesso!";
        }

        return "Não foi deletado!";
    }

}
