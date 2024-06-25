package com.grechi.tdddemo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "GROSS_VALUE")
    private BigDecimal grossValue;

    @Column(name = "NET_VALUE")
    private BigDecimal netValue;

    @Column(name = "DISCOUNT_VALUE")
    private BigDecimal discountValue;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "SALE_ID")
    private SaleNote saleNote;

}
