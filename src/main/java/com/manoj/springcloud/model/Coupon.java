package com.manoj.springcloud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "exp_date")
    private String expirationDate;

}
