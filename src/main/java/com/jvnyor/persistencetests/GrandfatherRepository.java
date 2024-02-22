package com.jvnyor.persistencetests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandfatherRepository extends JpaRepository<Grandfather, Long> {
}
