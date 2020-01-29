package com.bank.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnoreProperties("owner")
    private List<Card> cards = new ArrayList<>();
}
