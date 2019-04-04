package com.example.demo.bi.many2many;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@ToString(of = "id")
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "addresses")
    private Set<User> users= new HashSet<>();

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

}
