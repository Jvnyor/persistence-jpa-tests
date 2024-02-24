package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FatherRepository extends JpaRepository<Father, Long> {
    Optional<Father> findByDocumentId(String documentId);

    Optional<Father> findByPhone(String phone);

}
