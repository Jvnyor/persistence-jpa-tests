package com.jvnyor.persistencetests.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "sqGrandFather", sequenceName = "sq_grand_father", allocationSize = 1)
public class Grandfather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqGrandFather")
    private Long id;
    private String name;
    private String lastName;
    private int age;
    @ToString.Exclude
    @OneToMany(mappedBy = "grandfather", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Thing> things = new LinkedHashSet<>();

    public void addThing(Thing thing) {
        thing.setGrandfather(this);
        this.things.add(thing);
    }

    public void addThings(Set<Thing> things) {
        things.forEach(thing -> thing.setGrandfather(this));
        this.things.addAll(things);
    }
}
