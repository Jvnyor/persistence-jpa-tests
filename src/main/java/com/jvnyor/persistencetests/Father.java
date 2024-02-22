package com.jvnyor.persistencetests;

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
@SequenceGenerator(name = "sqFather", sequenceName = "sq_father", allocationSize = 1)
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqFather")
    private Long id;
    private String name;
    private String lastName;
    private int age;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "grandfather_id")
    private Grandfather grandfather;
    @ToString.Exclude
    @OneToMany(mappedBy = "father", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Thing> things = new LinkedHashSet<>();

    public void addThing(Thing thing) {
        thing.setFather(this);
        this.things.add(thing);
    }

    public void addThings(Set<Thing> things) {
        things.forEach(thing -> thing.setFather(this));
        this.things.addAll(things);
    }
}
