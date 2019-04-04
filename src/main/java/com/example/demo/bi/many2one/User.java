package com.example.demo.bi.many2one;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users", indexes = {@Index(name = "idx_users", columnList = "address_id")})
//@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;
}
