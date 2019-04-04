package com.example.demo.bi.many2one;

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
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> userSet = new HashSet<>();

    public Set<User> getUser() {
        return Collections.unmodifiableSet(userSet);
    }

    public void addUser(User user) {
        userSet.add(user);
        if (nonNull(user)) {
            user.setAddress(this);
        }
    }
}
