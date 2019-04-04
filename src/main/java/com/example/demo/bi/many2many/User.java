package com.example.demo.bi.many2many;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Setter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_addresses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")},
            indexes = {@Index(name = "idx_users_addresses", columnList = "user_id")})
    private Set<Address> addresses = new HashSet<>();

    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(addresses);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        if (nonNull(address)){
            address.addUser(this);
        }
    }

    public void removeAddress(Address address){
        addresses.remove(address);
        if (nonNull(address)){
            address.removeUser(this);
        }
    }
}