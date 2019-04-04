package com.example.demo.uni.one2many;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "addresses")
//@EqualsAndHashCode --musi byc
public class Address {

    @Id
    private Long id;
}
