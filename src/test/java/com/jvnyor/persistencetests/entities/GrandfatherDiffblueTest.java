package com.jvnyor.persistencetests.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GrandfatherDiffblueTest {
    /**
     * Method under test: {@link Grandfather#addThing(Thing)}
     */
    @Test
    void testAddThing() {
        // Arrange
        Grandfather grandfather = new Grandfather();

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setGrandfather(grandfather2);
        father.setId(1L);
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(1);
        grandfather4.setId(1L);
        grandfather4.setLastName("Doe");
        grandfather4.setName("Name");
        grandfather4.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather4);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father2);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father);
        thing.setGrandfather(grandfather3);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        // Act
        grandfather.addThing(thing);

        // Assert
        Grandfather grandfather5 = thing.getGrandfather();
        assertEquals(1, grandfather5.getThings().size());
        assertSame(grandfather, grandfather5);
    }

    /**
     * Method under test: {@link Grandfather#addThings(Set)}
     */
    @Test
    void testAddThings() {
        // Arrange
        Grandfather grandfather = new Grandfather();

        // Act
        grandfather.addThings(new HashSet<>());

        // Assert
        assertTrue(grandfather.getThings().isEmpty());
    }

    /**
     * Method under test: {@link Grandfather#addThings(Set)}
     */
    @Test
    void testAddThings2() {
        // Arrange
        Grandfather grandfather = new Grandfather();

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setGrandfather(grandfather2);
        father.setId(1L);
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(1);
        grandfather4.setId(1L);
        grandfather4.setLastName("Doe");
        grandfather4.setName("Name");
        grandfather4.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather4);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father2);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father);
        thing.setGrandfather(grandfather3);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        HashSet<Thing> things = new HashSet<>();
        things.add(thing);

        // Act
        grandfather.addThings(things);

        // Assert
        assertEquals(1, grandfather.getThings().size());
    }

    /**
     * Method under test: {@link Grandfather#addThings(Set)}
     */
    @Test
    void testAddThings3() {
        // Arrange
        Grandfather grandfather = new Grandfather();

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setGrandfather(grandfather2);
        father.setId(1L);
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(1);
        grandfather4.setId(1L);
        grandfather4.setLastName("Doe");
        grandfather4.setName("Name");
        grandfather4.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather4);
        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
        son.setFather(father2);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setFather(father);
        thing.setGrandfather(grandfather3);
        thing.setId(1L);
        thing.setName("Name");
        thing.setSon(son);

        Grandfather grandfather5 = new Grandfather();
        grandfather5.setAge(0);
        grandfather5.setId(2L);
        grandfather5.setLastName("Smith");
        grandfather5.setName("42");
        grandfather5.setThings(new HashSet<>());

        Father father3 = new Father();
        father3.setAge(0);
        father3.setDocumentId("Document Id");
        father3.setGrandfather(grandfather5);
        father3.setId(2L);
        father3.setLastName("Smith");
        father3.setName("42");
        father3.setPhone("8605550118");
        father3.setThings(new HashSet<>());

        Grandfather grandfather6 = new Grandfather();
        grandfather6.setAge(0);
        grandfather6.setId(2L);
        grandfather6.setLastName("Smith");
        grandfather6.setName("42");
        grandfather6.setThings(new HashSet<>());

        Grandfather grandfather7 = new Grandfather();
        grandfather7.setAge(0);
        grandfather7.setId(2L);
        grandfather7.setLastName("Smith");
        grandfather7.setName("42");
        grandfather7.setThings(new HashSet<>());

        Father father4 = new Father();
        father4.setAge(0);
        father4.setDocumentId("Document Id");
        father4.setGrandfather(grandfather7);
        father4.setId(2L);
        father4.setLastName("Smith");
        father4.setName("42");
        father4.setPhone("8605550118");
        father4.setThings(new HashSet<>());

        Son son2 = new Son();
        son2.setAge(0);
        son2.setFather(father4);
        son2.setId(2L);
        son2.setLastName("Smith");
        son2.setName("42");
        son2.setThings(new HashSet<>());

        Thing thing2 = new Thing();
        thing2.setFather(father3);
        thing2.setGrandfather(grandfather6);
        thing2.setId(2L);
        thing2.setName("42");
        thing2.setSon(son2);

        HashSet<Thing> things = new HashSet<>();
        things.add(thing2);
        things.add(thing);

        // Act
        grandfather.addThings(things);

        // Assert
        assertEquals(2, grandfather.getThings().size());
    }
}
