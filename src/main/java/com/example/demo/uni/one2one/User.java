package com.example.demo.uni.one2one;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;
}
