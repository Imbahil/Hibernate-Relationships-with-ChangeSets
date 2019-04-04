package com.example.demo.bi.one2many;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode
@Table(name = "addresses", indexes = {@Index(name = "idx_addresses", columnList = "user_id")})
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
