package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Father;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {FatherRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.jvnyor.persistencetests.entities"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class FatherRepositoryDiffblueTest {
    @Autowired
    private FatherRepository fatherRepository;

    /**
     * Method under test: {@link FatherRepository#findByDocumentId(String)}
     */
    @Test
    void testFindByDocumentId() {

        // Arrange

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(-1);
        father2.setDocumentId("Document Id");
        father2.setLastName("Smith");
        father2.setName("42");
        father2.setPhone("8605550118");
        father2.setThings(new HashSet<>());
        fatherRepository.save(father);
        fatherRepository.save(father2);

        // Act
        var optionalFather = fatherRepository.findByDocumentId("42");

        // Assert
        assertTrue(optionalFather.isPresent());
    }

    /**
     * Method under test: {@link FatherRepository#findByPhone(String)}
     */
    @Test
    void testFindByPhone() {

        // Arrange

        Father father = new Father();
        father.setAge(1);
        father.setDocumentId("42");
        father.setLastName("Doe");
        father.setName("Name");
        father.setPhone("6625550144");
        father.setThings(new HashSet<>());

        Father father2 = new Father();
        father2.setAge(-1);
        father2.setDocumentId("Document Id");
        father2.setLastName("Smith");
        father2.setName("42");
        father2.setPhone("8605550118");
        father2.setThings(new HashSet<>());
        fatherRepository.save(father);
        fatherRepository.save(father2);

        // Act
        var optionalFather = fatherRepository.findByPhone("6625550144");

        // Assert
        assertTrue(optionalFather.isPresent());
    }
}
