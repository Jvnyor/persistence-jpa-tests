package com.jvnyor.persistencetests.repositories;

import com.jvnyor.persistencetests.entities.Grandfather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandfatherRepository extends JpaRepository<Grandfather, Long> {
}
