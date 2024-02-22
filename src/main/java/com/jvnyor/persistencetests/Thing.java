package com.jvnyor.persistencetests;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "sqThings", sequenceName = "sq_things", allocationSize = 1)
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqFather")
    private Long id;
    private String name;

    @ManyToOne
//            (cascade = CascadeType.ALL) // In reverse relationship,
//            you get error if you set this entity already saved before transaction
    @JoinColumn(name = "grandfather_id")
    private Grandfather grandfather;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Father father;

    @ManyToOne
    @JoinColumn(name = "son_id")
    private Son son;

}
