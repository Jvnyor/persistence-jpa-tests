package com.jvnyor.persistencetests.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class FatherDiffblueTest {
    /**
     * Method under test: {@link Father#addThing(Thing)}
     */
    @Test
    void testAddThing() {
        // Arrange
        Father father = new Father();

        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Father father3 = new Father();
        father3.setAge(1);
        father3.setDocumentId("42");
        father3.setGrandfather(grandfather3);
        father3.setId(1L);
        father3.setLastName("Doe");
        father3.setName("Name");
        father3.setPhone("6625550144");
        father3.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father3);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father2);
        thing.setGrandfather(grandfather2);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        // Act
        father.addThing(thing);

        // Assert
        Father father4 = thing.getFather();
        assertEquals(1, father4.getThings().size());
        assertSame(father, father4);
    }

    /**
     * Method under test: {@link Father#addThings(Set)}
     */
    @Test
    void testAddThings() {
        // Arrange
        Father father = new Father();

        // Act
        father.addThings(new HashSet<>());

        // Assert
        assertTrue(father.getThings().isEmpty());
    }

    /**
     * Method under test: {@link Father#addThings(Set)}
     */
    @Test
    void testAddThings2() {
        // Arrange
        Father father = new Father();

        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Father father3 = new Father();
        father3.setAge(1);
        father3.setDocumentId("42");
        father3.setGrandfather(grandfather3);
        father3.setId(1L);
        father3.setLastName("Doe");
        father3.setName("Name");
        father3.setPhone("6625550144");
        father3.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father3);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father2);
        thing.setGrandfather(grandfather2);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        HashSet<Thing> things = new HashSet<>();
        things.add(thing);

        // Act
        father.addThings(things);

        // Assert
        assertEquals(1, father.getThings().size());
    }

    /**
     * Method under test: {@link Father#addThings(Set)}
     */
    @Test
    void testAddThings3() {
        // Arrange
        Father father = new Father();

        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Father father3 = new Father();
        father3.setAge(1);
        father3.setDocumentId("42");
        father3.setGrandfather(grandfather3);
        father3.setId(1L);
        father3.setLastName("Doe");
        father3.setName("Name");
        father3.setPhone("6625550144");
        father3.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father3);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father2);
        thing.setGrandfather(grandfather2);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(0);
        grandfather4.setId(2L);
        grandfather4.setLastName("Smith");
        grandfather4.setName("42");
        grandfather4.setThings(new HashSet<>());

        Father father4 = new Father();
        father4.setAge(0);
        father4.setDocumentId("Document Id");
        father4.setGrandfather(grandfather4);
        father4.setId(2L);
        father4.setLastName("Smith");
        father4.setName("42");
        father4.setPhone("8605550118");
        father4.setThings(new HashSet<>());

        Grandfather grandfather5 = new Grandfather();
        grandfather5.setAge(0);
        grandfather5.setId(2L);
        grandfather5.setLastName("Smith");
        grandfather5.setName("42");
        grandfather5.setThings(new HashSet<>());

        Grandfather grandfather6 = new Grandfather();
        grandfather6.setAge(0);
        grandfather6.setId(2L);
        grandfather6.setLastName("Smith");
        grandfather6.setName("42");
        grandfather6.setThings(new HashSet<>());

        Father father5 = new Father();
        father5.setAge(0);
        father5.setDocumentId("Document Id");
        father5.setGrandfather(grandfather6);
        father5.setId(2L);
        father5.setLastName("Smith");
        father5.setName("42");
        father5.setPhone("8605550118");
        father5.setThings(new HashSet<>());

        Son son2 = new Son();
        son2.setAge(0);
        son2.setFather(father5);
        son2.setId(2L);
        son2.setLastName("Smith");
        son2.setName("42");
        son2.setThings(new HashSet<>());

        Thing thing2 = new Thing();
        thing2.setFather(father4);
        thing2.setGrandfather(grandfather5);
        thing2.setId(2L);
        thing2.setName("42");
        thing2.setSon(son2);

        HashSet<Thing> things = new HashSet<>();
        things.add(thing2);
        things.add(thing);

        // Act
        father.addThings(things);

        // Assert
        assertEquals(2, father.getThings().size());
    }
}
