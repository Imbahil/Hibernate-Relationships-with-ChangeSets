package com.example.demo.bi.one2many;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {



    @Id
    @GeneratedValue
    private Long id;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "id")
//    @OrderBy("user_id")
    private List<Address> addressList = new ArrayList<>();

    public List<Address> getAddress() {
        return Collections.unmodifiableList(addressList);
    }

    public void addAddress(Address address) {
        addressList.add(address);
        if (nonNull(address)) {
            address.setUser(this);
        }
    }

    public void removeAddress(Address address) {
        addressList.remove(address);
        if (nonNull(address)) {
            address.setUser(null);
        }
    }
}