package com.devVItor.WebServices.Model;

import com.devVItor.WebServices.Model.Enum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    @NotNull
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name= "client_id")
    @JsonManagedReference
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment pagamento;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client, Payment pagamento) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
        this.pagamento = pagamento;
    }

    public Order(Instant moment, OrderStatus orderStatus, User client, Payment pagamento) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
        this.pagamento = pagamento;
    }

    public Order(Instant moment, OrderStatus orderStatus) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
    }

    public Order(Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {this.moment = moment;}

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPagamento() {
        return pagamento;
    }

    public void setPagamento(Payment pagamento) {
        this.pagamento = pagamento;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public double getTotal(){
        double total = 0;

        for(OrderItem item : items){
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", orderStatus=" + orderStatus +
                ", client=" + client.toString() +
                ", pagamento=" + pagamento.toString() +
                '}';
    }
}
