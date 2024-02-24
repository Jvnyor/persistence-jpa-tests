package com.jvnyor.persistencetests.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ThingDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Thing#Thing()}
     *   <li>{@link Thing#setFather(Father)}
     *   <li>{@link Thing#setGrandfather(Grandfather)}
     *   <li>{@link Thing#setId(Long)}
     *   <li>{@link Thing#setName(String)}
     *   <li>{@link Thing#setSon(Son)}
     *   <li>{@link Thing#toString()}
     *   <li>{@link Thing#getFather()}
     *   <li>{@link Thing#getGrandfather()}
     *   <li>{@link Thing#getId()}
     *   <li>{@link Thing#getName()}
     *   <li>{@link Thing#getSon()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Thing actualThing = new Thing();
        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());
        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setGrandfather(grandfather);
        father.setId(1L);
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());
        actualThing.setFather(father);
        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());
        actualThing.setGrandfather(grandfather2);
        actualThing.setId(1L);
        actualThing.setName("Name");
        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());
        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather3);
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
        actualThing.setSon(son);
        String actualToStringResult = actualThing.toString();
        Father actualFather = actualThing.getFather();
        Grandfather actualGrandfather = actualThing.getGrandfather();
        Long actualId = actualThing.getId();
        String actualName = actualThing.getName();
        Son actualSon = actualThing.getSon();

        // Assert that nothing has changed
        assertEquals("Name", actualName);
        assertEquals(
                "Thing(id=1, name=Name, grandfather=Grandfather(id=1, name=Name, lastName=Doe, age=1), father=Father(id=1,"
                        + " name=Name, documentId=42, phone=6625550144, lastName=Doe, age=1), son=Son(id=1, name=Name, lastName=Doe,"
                        + " age=1))",
                actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertSame(father, actualFather);
        assertSame(grandfather2, actualGrandfather);
        assertSame(son, actualSon);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Thing#Thing(Long, String, Grandfather, Father, Son)}
     *   <li>{@link Thing#setFather(Father)}
     *   <li>{@link Thing#setGrandfather(Grandfather)}
     *   <li>{@link Thing#setId(Long)}
     *   <li>{@link Thing#setName(String)}
     *   <li>{@link Thing#setSon(Son)}
     *   <li>{@link Thing#toString()}
     *   <li>{@link Thing#getFather()}
     *   <li>{@link Thing#getGrandfather()}
     *   <li>{@link Thing#getId()}
     *   <li>{@link Thing#getName()}
     *   <li>{@link Thing#getSon()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());

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

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
        father2.setGrandfather(grandfather3);
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

        // Act
        Thing actualThing = new Thing(1L, "Name", grandfather, father, son);
        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(1);
        grandfather4.setId(1L);
        grandfather4.setLastName("Doe");
        grandfather4.setName("Name");
        grandfather4.setThings(new HashSet<>());
        Father father3 = new Father();
        father3.setAge(1);
        father3.setDocumentId("42");
        father3.setGrandfather(grandfather4);
        father3.setId(1L);
        father3.setLastName("Doe");
        father3.setName("Name");
        father3.setPhone("6625550144");
        father3.setThings(new HashSet<>());
        actualThing.setFather(father3);
        Grandfather grandfather5 = new Grandfather();
        grandfather5.setAge(1);
        grandfather5.setId(1L);
        grandfather5.setLastName("Doe");
        grandfather5.setName("Name");
        grandfather5.setThings(new HashSet<>());
        actualThing.setGrandfather(grandfather5);
        actualThing.setId(1L);
        actualThing.setName("Name");
        Grandfather grandfather6 = new Grandfather();
        grandfather6.setAge(1);
        grandfather6.setId(1L);
        grandfather6.setLastName("Doe");
        grandfather6.setName("Name");
        grandfather6.setThings(new HashSet<>());
        Father father4 = new Father();
        father4.setAge(1);
        father4.setDocumentId("42");
        father4.setGrandfather(grandfather6);
        father4.setId(1L);
        father4.setLastName("Doe");
        father4.setName("Name");
        father4.setPhone("6625550144");
        father4.setThings(new HashSet<>());
        Son son2 = new Son();
        son2.setAge(1);
        son2.setFather(father4);
        son2.setId(1L);
        son2.setLastName("Doe");
        son2.setName("Name");
        son2.setThings(new HashSet<>());
        actualThing.setSon(son2);
        String actualToStringResult = actualThing.toString();
        Father actualFather = actualThing.getFather();
        Grandfather actualGrandfather = actualThing.getGrandfather();
        Long actualId = actualThing.getId();
        String actualName = actualThing.getName();
        Son actualSon = actualThing.getSon();

        // Assert that nothing has changed
        assertEquals("Name", actualName);
        assertEquals(
                "Thing(id=1, name=Name, grandfather=Grandfather(id=1, name=Name, lastName=Doe, age=1), father=Father(id=1,"
                        + " name=Name, documentId=42, phone=6625550144, lastName=Doe, age=1), son=Son(id=1, name=Name, lastName=Doe,"
                        + " age=1))",
                actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertSame(father3, actualFather);
        assertSame(grandfather5, actualGrandfather);
        assertSame(son2, actualSon);
    }
}
