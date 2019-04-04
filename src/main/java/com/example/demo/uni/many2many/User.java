package com.example.demo.uni.many2many;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Setter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_addresses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "address_id"),
            indexes = @Index(name = "dx_users_addresses", columnList = "user_id"))
    private Set<Address> addressSet = new HashSet<>();

    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(addressSet);
    }

    public void addAddress(Address address) {
        addressSet.add(address);
    }

    public void removeAddress(Address address) {
        addressSet.remove(address);
    }
}
