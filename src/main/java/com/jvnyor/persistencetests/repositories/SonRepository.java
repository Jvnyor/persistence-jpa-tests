package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SonRepository extends JpaRepository<Son, Long> {
}
