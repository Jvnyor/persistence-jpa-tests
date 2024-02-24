package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Father;
import com.jvnyor.persistencetests.entities.Grandfather;
import com.jvnyor.persistencetests.entities.Son;
import com.jvnyor.persistencetests.entities.Thing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ContextConfiguration(classes = {
        ThingRepository.class,
        FatherRepository.class,
        GrandfatherRepository.class,
        SonRepository.class
})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.jvnyor.persistencetests.entities"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class ThingRepositoryDiffblueTest {
    @Autowired
    private ThingRepository thingRepository;

    @Autowired
    private GrandfatherRepository grandfatherRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private SonRepository sonRepository;

    /**
     * Method under test:
     * {@link ThingRepository#findByIdAndGrandfather_IdAndFather_IdAndSon_Id(Long, Long, Long, Long)}
     */
    @Test
    void testFindByIdAndGrandfather_IdAndFather_IdAndSon_Id() {
        // Arrange
        Grandfather grandfather = new Grandfather();
        grandfather.setAge(1);
//        grandfather.setId(1L);
        grandfather.setLastName("Doe");
        grandfather.setName("Name");
        grandfather.setThings(new HashSet<>());

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
//        father.setGrandfather(grandfather);
        father.setId(1L);
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Grandfather grandfather2 = new Grandfather();
        grandfather2.setAge(1);
        grandfather2.setId(1L);
        grandfather2.setLastName("Doe");
        grandfather2.setName("Name");
        grandfather2.setThings(new HashSet<>());

        Grandfather grandfather3 = new Grandfather();
        grandfather3.setAge(1);
//        grandfather3.setId(1L);
        grandfather3.setLastName("Doe");
        grandfather3.setName("Name");
        grandfather3.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(1);
        father2.setDocumentId("42");
//        father2.setGrandfather(grandfather3);
//        father2.setId(1L);
        father2.setLastName("Doe");
        father2.setName("Name");
        father2.setPhone("6625550144");
        father2.setThings(new HashSet<>());

        Son son = new Son();
        son.setAge(1);
//        son.setFather(father2);
        son.setId(1L);
        son.setLastName("Doe");
        son.setName("Name");
        son.setThings(new HashSet<>());

        Thing thing = new Thing();
        thing.setId(1L);
        thing.setFather(fatherRepository.save(father));
        thing.setGrandfather(grandfatherRepository.save(grandfather2));
        thing.setName("Name");
        thing.setSon(sonRepository.save(son));

        Grandfather grandfather4 = new Grandfather();
        grandfather4.setAge(-1);
//        grandfather4.setId(2L);
        grandfather4.setLastName("Smith");
        grandfather4.setName("42");
        grandfather4.setThings(new HashSet<>());

        Father father3 = new Father();
        father3.setAge(-1);
        father3.setDocumentId("Document Id");
//        father3.setGrandfather(grandfather4);
//        father3.setId(2L);
        father3.setLastName("Smith");
        father3.setName("42");
        father3.setPhone("8605550118");
        father3.setThings(new HashSet<>());

        Grandfather grandfather5 = new Grandfather();
        grandfather5.setAge(-1);
//        grandfather5.setId(2L);
        grandfather5.setLastName("Smith");
        grandfather5.setName("42");
        grandfather5.setThings(new HashSet<>());

        Grandfather grandfather6 = new Grandfather();
        grandfather6.setAge(-1);
//        grandfather6.setId(2L);
        grandfather6.setLastName("Smith");
        grandfather6.setName("42");
        grandfather6.setThings(new HashSet<>());

        Father father4 = new Father();
        father4.setAge(-1);
        father4.setDocumentId("Document Id");
//        father4.setGrandfather(grandfather6);
//        father4.setId(2L);
        father4.setLastName("Smith");
        father4.setName("42");
        father4.setPhone("8605550118");
        father4.setThings(new HashSet<>());

        Son son2 = new Son();
        son2.setAge(-1);
//        son2.setFather(father4);
//        son2.setId(2L);
        son2.setLastName("Smith");
        son2.setName("42");
        son2.setThings(new HashSet<>());

        Thing thing2 = new Thing();
        thing2.setId(2L);
        thing2.setFather(fatherRepository.save(father3));
        thing2.setGrandfather(grandfatherRepository.save(grandfather5));
        thing2.setName("42");
        thing2.setSon(sonRepository.save(son2));
        thingRepository.save(thing);
        thingRepository.save(thing2);

        // Act
        var thingSet = thingRepository.findByIdAndGrandfather_IdAndFather_IdAndSon_Id(thing.getId(), 1L, 1L, 1L);

        // Assert
        assertFalse(thingSet.isEmpty());
    }
}
