package com.example.demo.uni.many2many;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;
}
