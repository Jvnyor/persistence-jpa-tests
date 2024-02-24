package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {
    Set<Thing> findByIdAndGrandfather_IdAndFather_IdAndSon_Id(Long id, Long grandfatherId, Long fatherId, Long sonId);

}
