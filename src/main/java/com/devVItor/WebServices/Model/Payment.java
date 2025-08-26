package com.devVItor.WebServices.Model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Instant date;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable= true, unique = true)
    private Order order;

    public Payment() {
    }

    public Payment(Instant date) {
        this.date = date;
    }

    public Payment(Long id, Instant date) {
        this.id = id;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", order=" + order +
                '}';
    }
}
