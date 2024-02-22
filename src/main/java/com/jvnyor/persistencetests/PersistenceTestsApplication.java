package com.jvnyor.persistencetests;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class PersistenceTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceTestsApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(FamilyService familyService) {
        return args -> {
            var grandfather = new Grandfather();
            grandfather.setName("John");
            grandfather.setLastName("Doe");
            grandfather.setAge(70);
            var thing = new Thing();
            thing.setName("Car");
//            grandfather.addThing(thing);
            var father = new Father();
            father.setName("Peter");
            father.setLastName("Doe");
            father.setAge(40);
            var son = new Son();
            son.setName("Tom");
            son.setLastName("Doe");
            son.setAge(20);

            familyService.saveFamily(grandfather, father, son, Set.of(thing));

            var allThings = familyService.getAllThingsCount();
            var allGrandfathersCount = familyService.getAllGrandfathersCount();
            var allFathersCount = familyService.getAllFathersCount();
            var allSonsCount = familyService.getAllSonsCount();
            log.info("All things count: {}", allThings);
            log.info("All grandfathers count: {}", allGrandfathersCount);
            log.info("All fathers count: {}", allFathersCount);
            log.info("All sons count: {}", allSonsCount);

            var grandFatherSaved = familyService.findGrandfatherById(1L);
            log.info("Grandfather saved: {}", grandFatherSaved);
            var fatherSaved = familyService.findFatherById(1L);
            log.info("Father saved: {}", fatherSaved);
            var sonSaved = familyService.findSonById(1L);
            log.info("Son saved: {}", sonSaved);
            var thingsSaved = familyService.findThingsByFamilyIds(2L, 1L, 1L, 1L);
            log.info("Things saved: {}", thingsSaved);

            familyService.saveFamily(grandFatherSaved, fatherSaved, sonSaved, thingsSaved);

            var allThings2 = familyService.getAllThingsCount();
            var allGrandfathersCount2 = familyService.getAllGrandfathersCount();
            var allFathersCount2 = familyService.getAllFathersCount();
            var allSonsCount2 = familyService.getAllSonsCount();
            log.info("All things count: {}", allThings2);
            log.info("All grandfathers count: {}", allGrandfathersCount2);
            log.info("All fathers count: {}", allFathersCount2);
            log.info("All sons count: {}", allSonsCount2);
        };
    }
}
