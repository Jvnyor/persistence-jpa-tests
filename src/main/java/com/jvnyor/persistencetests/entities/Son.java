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
@SequenceGenerator(name = "sqSon", sequenceName = "sq_son", allocationSize = 1)
public class Son {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqSon")
    private Long id;
    private String name;
    private String lastName;
    private int age;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "father_id")
    private Father father;
    @ToString.Exclude
    @OneToMany(mappedBy = "son", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Thing> things = new LinkedHashSet<>();

    public void addThing(Thing thing) {
        thing.setSon(this);
        this.things.add(thing);
    }

    public void addThings(Set<Thing> things) {
        things.forEach(thing -> thing.setSon(this));
        this.things.addAll(things);
    }
}
