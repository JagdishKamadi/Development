package com.epam.onetomanymappingdemo1.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;
    private String customerName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "customerId")
    private List<Product> products = new ArrayList<>();
}