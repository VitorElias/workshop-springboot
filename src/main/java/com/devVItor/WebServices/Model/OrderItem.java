package com.devVItor.WebServices.Model;

import com.devVItor.WebServices.Model.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private int quantidade;

    private double preco;

    public OrderItem(int quantidade, double preco, Order order, Product product) {

        id.setOrder(order);
        id.setProduct(product);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public OrderItem() {
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct (Product pr) {
        id.setProduct(pr);
    }

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public double getPreco() {return preco;}

    public void setPreco(double preco) {this.preco = preco;}

    public double getSubTotal(){return preco * quantidade;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
