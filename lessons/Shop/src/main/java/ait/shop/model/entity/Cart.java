package ait.shop.model.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name ="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private  Customer customer;

    //private List<Product> products;
}
