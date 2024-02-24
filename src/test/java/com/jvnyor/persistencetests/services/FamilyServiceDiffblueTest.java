package com.jvnyor.persistencetests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.jvnyor.persistencetests.entities.Father;
import com.jvnyor.persistencetests.entities.Grandfather;
import com.jvnyor.persistencetests.entities.Son;
import com.jvnyor.persistencetests.entities.Thing;
import com.jvnyor.persistencetests.repositories.FatherRepository;
import com.jvnyor.persistencetests.repositories.GrandfatherRepository;
import com.jvnyor.persistencetests.repositories.SonRepository;
import com.jvnyor.persistencetests.repositories.ThingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FamilyService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FamilyServiceDiffblueTest {
  @Autowired
  private FamilyService familyService;

  @MockBean
  private FatherRepository fatherRepository;

  @MockBean
  private GrandfatherRepository grandfatherRepository;

  @MockBean
  private SonRepository sonRepository;

  @MockBean
  private ThingRepository thingRepository;

  /**
   * Method under test: {@link FamilyService#getAllThingsCount()}
   */
  @Test
  void testGetAllThingsCount() {
    // Arrange
    when(thingRepository.count()).thenReturn(3L);

    // Act
    long actualAllThingsCount = familyService.getAllThingsCount();

    // Assert
    verify(thingRepository).count();
    assertEquals(3L, actualAllThingsCount);
  }

  /**
   * Method under test: {@link FamilyService#getAllGrandfathersCount()}
   */
  @Test
  void testGetAllGrandfathersCount() {
    // Arrange
    when(grandfatherRepository.count()).thenReturn(3L);

    // Act
    long actualAllGrandfathersCount = familyService.getAllGrandfathersCount();

    // Assert
    verify(grandfatherRepository).count();
    assertEquals(3L, actualAllGrandfathersCount);
  }

  /**
   * Method under test: {@link FamilyService#getAllFathersCount()}
   */
  @Test
  void testGetAllFathersCount() {
    // Arrange
    when(fatherRepository.count()).thenReturn(3L);

    // Act
    long actualAllFathersCount = familyService.getAllFathersCount();

    // Assert
    verify(fatherRepository).count();
    assertEquals(3L, actualAllFathersCount);
  }

  /**
   * Method under test: {@link FamilyService#getAllSonsCount()}
   */
  @Test
  void testGetAllSonsCount() {
    // Arrange
    when(sonRepository.count()).thenReturn(3L);

    // Act
    long actualAllSonsCount = familyService.getAllSonsCount();

    // Assert
    verify(sonRepository).count();
    assertEquals(3L, actualAllSonsCount);
  }

  /**
   * Method under test:
   * {@link FamilyService#saveFamily(Grandfather, Father, Son, Set)}
   */
  @Test
  void testSaveFamily() {
    // Arrange
    Grandfather grandfather = new Grandfather();
    grandfather.setAge(1);
    grandfather.setId(1L);
    grandfather.setLastName("Doe");
    grandfather.setName("Name");
    grandfather.setThings(new HashSet<>());
    when(grandfatherRepository.save(Mockito.<Grandfather>any())).thenReturn(grandfather);

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
    when(fatherRepository.save(Mockito.<Father>any())).thenReturn(father);

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
    when(sonRepository.save(Mockito.<Son>any())).thenReturn(son);
    when(thingRepository.saveAll(Mockito.<Iterable<Thing>>any())).thenReturn(new ArrayList<>());

    Grandfather grandfather4 = new Grandfather();
    grandfather4.setAge(1);
    grandfather4.setId(1L);
    grandfather4.setLastName("Doe");
    grandfather4.setName("Name");
    grandfather4.setThings(new HashSet<>());

    Grandfather grandfather5 = new Grandfather();
    grandfather5.setAge(1);
    grandfather5.setId(1L);
    grandfather5.setLastName("Doe");
    grandfather5.setName("Name");
    grandfather5.setThings(new HashSet<>());

    Father father3 = new Father();
    father3.setAge(1);
    father3.setDocumentId("42");
    father3.setGrandfather(grandfather5);
    father3.setId(1L);
    father3.setLastName("Doe");
    father3.setName("Name");
    father3.setPhone("6625550144");
    father3.setThings(new HashSet<>());

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

    // Act
    familyService.saveFamily(grandfather4, father3, son2, new HashSet<>());

    // Assert
    verify(fatherRepository).save(Mockito.<Father>any());
    verify(grandfatherRepository).save(Mockito.<Grandfather>any());
    verify(sonRepository).save(Mockito.<Son>any());
    verify(thingRepository).saveAll(Mockito.<Iterable<Thing>>any());
    assertSame(father, son2.getFather());
    assertSame(grandfather, father3.getGrandfather());
  }

  /**
   * Method under test: {@link FamilyService#saveGrandFather(Grandfather)}
   */
  @Test
  void testSaveGrandFather() {
    // Arrange
    Grandfather grandfather = new Grandfather();
    grandfather.setAge(1);
    grandfather.setId(1L);
    grandfather.setLastName("Doe");
    grandfather.setName("Name");
    grandfather.setThings(new HashSet<>());
    when(grandfatherRepository.save(Mockito.<Grandfather>any())).thenReturn(grandfather);

    Grandfather grandfather2 = new Grandfather();
    grandfather2.setAge(1);
    grandfather2.setId(1L);
    grandfather2.setLastName("Doe");
    grandfather2.setName("Name");
    grandfather2.setThings(new HashSet<>());

    // Act
    Grandfather actualSaveGrandFatherResult = familyService.saveGrandFather(grandfather2);

    // Assert
    verify(grandfatherRepository).save(Mockito.<Grandfather>any());
    assertSame(grandfather, actualSaveGrandFatherResult);
  }

  /**
   * Method under test: {@link FamilyService#saveFather(Father, Grandfather)}
   */
  @Test
  void testSaveFather() {
    // Arrange
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
    when(fatherRepository.save(Mockito.<Father>any())).thenReturn(father);

    Grandfather grandfather2 = new Grandfather();
    grandfather2.setAge(1);
    grandfather2.setId(1L);
    grandfather2.setLastName("Doe");
    grandfather2.setName("Name");
    grandfather2.setThings(new HashSet<>());

    Father father2 = new Father();
    father2.setAge(1);
    father2.setDocumentId("42");
    father2.setGrandfather(grandfather2);
    father2.setId(1L);
    father2.setLastName("Doe");
    father2.setName("Name");
    father2.setPhone("6625550144");
    father2.setThings(new HashSet<>());

    Grandfather grandfather3 = new Grandfather();
    grandfather3.setAge(1);
    grandfather3.setId(1L);
    grandfather3.setLastName("Doe");
    grandfather3.setName("Name");
    grandfather3.setThings(new HashSet<>());

    // Act
    Father actualSaveFatherResult = familyService.saveFather(father2, grandfather3);

    // Assert
    verify(fatherRepository).save(Mockito.<Father>any());
    assertSame(father, actualSaveFatherResult);
    assertSame(grandfather3, father2.getGrandfather());
  }

  /**
   * Method under test: {@link FamilyService#saveSon(Son, Father)}
   */
  @Test
  void testSaveSon() {
    // Arrange
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

    Son son = new Son();
    son.setAge(1);
    son.setFather(father);
    son.setId(1L);
    son.setLastName("Doe");
    son.setName("Name");
    son.setThings(new HashSet<>());
    when(sonRepository.save(Mockito.<Son>any())).thenReturn(son);

    Grandfather grandfather2 = new Grandfather();
    grandfather2.setAge(1);
    grandfather2.setId(1L);
    grandfather2.setLastName("Doe");
    grandfather2.setName("Name");
    grandfather2.setThings(new HashSet<>());

    Father father2 = new Father();
    father2.setAge(1);
    father2.setDocumentId("42");
    father2.setGrandfather(grandfather2);
    father2.setId(1L);
    father2.setLastName("Doe");
    father2.setName("Name");
    father2.setPhone("6625550144");
    father2.setThings(new HashSet<>());

    Son son2 = new Son();
    son2.setAge(1);
    son2.setFather(father2);
    son2.setId(1L);
    son2.setLastName("Doe");
    son2.setName("Name");
    son2.setThings(new HashSet<>());

    Grandfather grandfather3 = new Grandfather();
    grandfather3.setAge(1);
    grandfather3.setId(1L);
    grandfather3.setLastName("Doe");
    grandfather3.setName("Name");
    grandfather3.setThings(new HashSet<>());

    Father father3 = new Father();
    father3.setAge(1);
    father3.setDocumentId("42");
    father3.setGrandfather(grandfather3);
    father3.setId(1L);
    father3.setLastName("Doe");
    father3.setName("Name");
    father3.setPhone("6625550144");
    father3.setThings(new HashSet<>());

    // Act
    Son actualSaveSonResult = familyService.saveSon(son2, father3);

    // Assert
    verify(sonRepository).save(Mockito.<Son>any());
    assertSame(father3, son2.getFather());
    assertSame(son, actualSaveSonResult);
  }

  /**
   * Method under test:
   * {@link FamilyService#saveThings(Set, Grandfather, Father, Son)}
   */
  @Test
  void testSaveThings() {
    // Arrange
    when(thingRepository.saveAll(Mockito.<Iterable<Thing>>any())).thenReturn(new ArrayList<>());
    HashSet<Thing> things = new HashSet<>();

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
    familyService.saveThings(things, grandfather, father, son);

    // Assert that nothing has changed
    verify(thingRepository).saveAll(Mockito.<Iterable<Thing>>any());
    assertEquals("42", father.getDocumentId());
    assertEquals("6625550144", father.getPhone());
    assertEquals("Doe", father.getLastName());
    assertEquals("Doe", grandfather.getLastName());
    assertEquals("Doe", son.getLastName());
    assertEquals("Name", father.getName());
    assertEquals("Name", grandfather.getName());
    assertEquals("Name", son.getName());
    assertEquals(1, father.getAge());
    assertEquals(1, grandfather.getAge());
    assertEquals(1, son.getAge());
    assertEquals(1L, father.getId().longValue());
    assertEquals(1L, grandfather.getId().longValue());
    assertEquals(1L, son.getId().longValue());
    assertTrue(father.getThings().isEmpty());
    assertTrue(grandfather.getThings().isEmpty());
    assertTrue(son.getThings().isEmpty());
    assertSame(father2, son.getFather());
    assertSame(grandfather2, father.getGrandfather());
  }

  /**
   * Method under test:
   * {@link FamilyService#saveThings(Set, Grandfather, Father, Son)}
   */
  @Test
  void testSaveThings2() {
    // Arrange
    when(thingRepository.saveAll(Mockito.<Iterable<Thing>>any())).thenReturn(new ArrayList<>());

    Grandfather grandfather = new Grandfather();
    grandfather.setAge(1);
    grandfather.setId(1L);
    grandfather.setLastName("Doe");
    grandfather.setName("Things saved: {}");
    grandfather.setThings(new HashSet<>());

    Father father = new Father();
    father.setAge(1);
    father.setDocumentId("42");
    father.setGrandfather(grandfather);
    father.setId(1L);
    father.setLastName("Doe");
    father.setName("Things saved: {}");
    father.setPhone("6625550144");
    father.setThings(new HashSet<>());

    Grandfather grandfather2 = new Grandfather();
    grandfather2.setAge(1);
    grandfather2.setId(1L);
    grandfather2.setLastName("Doe");
    grandfather2.setName("Things saved: {}");
    grandfather2.setThings(new HashSet<>());

    Grandfather grandfather3 = new Grandfather();
    grandfather3.setAge(1);
    grandfather3.setId(1L);
    grandfather3.setLastName("Doe");
    grandfather3.setName("Things saved: {}");
    grandfather3.setThings(new HashSet<>());

    Father father2 = new Father();
    father2.setAge(1);
    father2.setDocumentId("42");
    father2.setGrandfather(grandfather3);
    father2.setId(1L);
    father2.setLastName("Doe");
    father2.setName("Things saved: {}");
    father2.setPhone("6625550144");
    father2.setThings(new HashSet<>());

    Son son = new Son();
    son.setAge(1);
    son.setFather(father2);
    son.setId(1L);
    son.setLastName("Doe");
    son.setName("Things saved: {}");
    son.setThings(new HashSet<>());

    Thing thing = new Thing();
    thing.setFather(father);
    thing.setGrandfather(grandfather2);
    thing.setId(1L);
    thing.setName("Things saved: {}");
    thing.setSon(son);

    HashSet<Thing> things = new HashSet<>();
    things.add(thing);

    Grandfather grandfather4 = new Grandfather();
    grandfather4.setAge(1);
    grandfather4.setId(1L);
    grandfather4.setLastName("Doe");
    grandfather4.setName("Name");
    grandfather4.setThings(new HashSet<>());

    Grandfather grandfather5 = new Grandfather();
    grandfather5.setAge(1);
    grandfather5.setId(1L);
    grandfather5.setLastName("Doe");
    grandfather5.setName("Name");
    grandfather5.setThings(new HashSet<>());

    Father father3 = new Father();
    father3.setAge(1);
    father3.setDocumentId("42");
    father3.setGrandfather(grandfather5);
    father3.setId(1L);
    father3.setLastName("Doe");
    father3.setName("Name");
    father3.setPhone("6625550144");
    father3.setThings(new HashSet<>());

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

    // Act
    familyService.saveThings(things, grandfather4, father3, son2);

    // Assert
    verify(thingRepository).saveAll(Mockito.<Iterable<Thing>>any());
  }

  /**
   * Method under test:
   * {@link FamilyService#saveThings(Set, Grandfather, Father, Son)}
   */
  @Test
  void testSaveThings3() {
    // Arrange
    when(thingRepository.saveAll(Mockito.<Iterable<Thing>>any())).thenReturn(new ArrayList<>());

    Grandfather grandfather = new Grandfather();
    grandfather.setAge(1);
    grandfather.setId(1L);
    grandfather.setLastName("Doe");
    grandfather.setName("Things saved: {}");
    grandfather.setThings(new HashSet<>());

    Father father = new Father();
    father.setAge(1);
    father.setDocumentId("42");
    father.setGrandfather(grandfather);
    father.setId(1L);
    father.setLastName("Doe");
    father.setName("Things saved: {}");
    father.setPhone("6625550144");
    father.setThings(new HashSet<>());

    Grandfather grandfather2 = new Grandfather();
    grandfather2.setAge(1);
    grandfather2.setId(1L);
    grandfather2.setLastName("Doe");
    grandfather2.setName("Things saved: {}");
    grandfather2.setThings(new HashSet<>());

    Grandfather grandfather3 = new Grandfather();
    grandfather3.setAge(1);
    grandfather3.setId(1L);
    grandfather3.setLastName("Doe");
    grandfather3.setName("Things saved: {}");
    grandfather3.setThings(new HashSet<>());

    Father father2 = new Father();
    father2.setAge(1);
    father2.setDocumentId("42");
    father2.setGrandfather(grandfather3);
    father2.setId(1L);
    father2.setLastName("Doe");
    father2.setName("Things saved: {}");
    father2.setPhone("6625550144");
    father2.setThings(new HashSet<>());

    Son son = new Son();
    son.setAge(1);
    son.setFather(father2);
    son.setId(1L);
    son.setLastName("Doe");
    son.setName("Things saved: {}");
    son.setThings(new HashSet<>());

    Thing thing = new Thing();
    thing.setFather(father);
    thing.setGrandfather(grandfather2);
    thing.setId(1L);
    thing.setName("Things saved: {}");
    thing.setSon(son);

    Grandfather grandfather4 = new Grandfather();
    grandfather4.setAge(0);
    grandfather4.setId(2L);
    grandfather4.setLastName("Smith");
    grandfather4.setName("Name");
    grandfather4.setThings(new HashSet<>());

    Father father3 = new Father();
    father3.setAge(0);
    father3.setDocumentId("Things saved: {}");
    father3.setGrandfather(grandfather4);
    father3.setId(2L);
    father3.setLastName("Smith");
    father3.setName("Name");
    father3.setPhone("8605550118");
    father3.setThings(new HashSet<>());

    Grandfather grandfather5 = new Grandfather();
    grandfather5.setAge(0);
    grandfather5.setId(2L);
    grandfather5.setLastName("Smith");
    grandfather5.setName("Name");
    grandfather5.setThings(new HashSet<>());

    Grandfather grandfather6 = new Grandfather();
    grandfather6.setAge(0);
    grandfather6.setId(2L);
    grandfather6.setLastName("Smith");
    grandfather6.setName("Name");
    grandfather6.setThings(new HashSet<>());

    Father father4 = new Father();
    father4.setAge(0);
    father4.setDocumentId("Things saved: {}");
    father4.setGrandfather(grandfather6);
    father4.setId(2L);
    father4.setLastName("Smith");
    father4.setName("Name");
    father4.setPhone("8605550118");
    father4.setThings(new HashSet<>());

    Son son2 = new Son();
    son2.setAge(0);
    son2.setFather(father4);
    son2.setId(2L);
    son2.setLastName("Smith");
    son2.setName("Name");
    son2.setThings(new HashSet<>());

    Thing thing2 = new Thing();
    thing2.setFather(father3);
    thing2.setGrandfather(grandfather5);
    thing2.setId(2L);
    thing2.setName("Name");
    thing2.setSon(son2);

    HashSet<Thing> things = new HashSet<>();
    things.add(thing2);
    things.add(thing);

    Grandfather grandfather7 = new Grandfather();
    grandfather7.setAge(1);
    grandfather7.setId(1L);
    grandfather7.setLastName("Doe");
    grandfather7.setName("Name");
    grandfather7.setThings(new HashSet<>());

    Grandfather grandfather8 = new Grandfather();
    grandfather8.setAge(1);
    grandfather8.setId(1L);
    grandfather8.setLastName("Doe");
    grandfather8.setName("Name");
    grandfather8.setThings(new HashSet<>());

    Father father5 = new Father();
    father5.setAge(1);
    father5.setDocumentId("42");
    father5.setGrandfather(grandfather8);
    father5.setId(1L);
    father5.setLastName("Doe");
    father5.setName("Name");
    father5.setPhone("6625550144");
    father5.setThings(new HashSet<>());

    Grandfather grandfather9 = new Grandfather();
    grandfather9.setAge(1);
    grandfather9.setId(1L);
    grandfather9.setLastName("Doe");
    grandfather9.setName("Name");
    grandfather9.setThings(new HashSet<>());

    Father father6 = new Father();
    father6.setAge(1);
    father6.setDocumentId("42");
    father6.setGrandfather(grandfather9);
    father6.setId(1L);
    father6.setLastName("Doe");
    father6.setName("Name");
    father6.setPhone("6625550144");
    father6.setThings(new HashSet<>());

    Son son3 = new Son();
    son3.setAge(1);
    son3.setFather(father6);
    son3.setId(1L);
    son3.setLastName("Doe");
    son3.setName("Name");
    son3.setThings(new HashSet<>());

    // Act
    familyService.saveThings(things, grandfather7, father5, son3);

    // Assert
    verify(thingRepository).saveAll(Mockito.<Iterable<Thing>>any());
  }

  /**
   * Method under test: {@link FamilyService#findGrandfatherById(Long)}
   */
  @Test
  void testFindGrandfatherById() {
    // Arrange
    Grandfather grandfather = new Grandfather();
    grandfather.setAge(1);
    grandfather.setId(1L);
    grandfather.setLastName("Doe");
    grandfather.setName("Name");
    grandfather.setThings(new HashSet<>());
    Optional<Grandfather> ofResult = Optional.of(grandfather);
    when(grandfatherRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    // Act
    Grandfather actualFindGrandfatherByIdResult = familyService.findGrandfatherById(1L);

    // Assert
    verify(grandfatherRepository).findById(Mockito.<Long>any());
    assertSame(grandfather, actualFindGrandfatherByIdResult);
  }

  /**
   * Method under test: {@link FamilyService#findFatherById(Long)}
   */
  @Test
  void testFindFatherById() {
    // Arrange
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
    Optional<Father> ofResult = Optional.of(father);
    when(fatherRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    // Act
    Father actualFindFatherByIdResult = familyService.findFatherById(1L);

    // Assert
    verify(fatherRepository).findById(Mockito.<Long>any());
    assertSame(father, actualFindFatherByIdResult);
  }

  /**
   * Method under test: {@link FamilyService#findSonById(Long)}
   */
  @Test
  void testFindSonById() {
    // Arrange
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

    Son son = new Son();
    son.setAge(1);
    son.setFather(father);
    son.setId(1L);
    son.setLastName("Doe");
    son.setName("Name");
    son.setThings(new HashSet<>());
    Optional<Son> ofResult = Optional.of(son);
    when(sonRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    // Act
    Son actualFindSonByIdResult = familyService.findSonById(1L);

    // Assert
    verify(sonRepository).findById(Mockito.<Long>any());
    assertSame(son, actualFindSonByIdResult);
  }

  /**
   * Method under test:
   * {@link FamilyService#findThingsByFamilyIds(Long, Long, Long, Long)}
   */
  @Test
  void testFindThingsByFamilyIds() {
    // Arrange
    HashSet<Thing> thingSet = new HashSet<>();
    when(thingRepository.findByIdAndGrandfather_IdAndFather_IdAndSon_Id(Mockito.<Long>any(), Mockito.<Long>any(),
            Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(thingSet);

    // Act
    Set<Thing> actualFindThingsByFamilyIdsResult = familyService.findThingsByFamilyIds(1L, 1L, 1L, 1L);

    // Assert
    verify(thingRepository).findByIdAndGrandfather_IdAndFather_IdAndSon_Id(Mockito.<Long>any(), Mockito.<Long>any(),
            Mockito.<Long>any(), Mockito.<Long>any());
    assertTrue(actualFindThingsByFamilyIdsResult.isEmpty());
    assertSame(thingSet, actualFindThingsByFamilyIdsResult);
  }

  /**
   * Method under test: {@link FamilyService#findByDocumentId(String)}
   */
  @Test
  void testFindByDocumentId() {
    // Arrange
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
    Optional<Father> ofResult = Optional.of(father);
    when(fatherRepository.findByDocumentId(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    Optional<Father> actualFindByDocumentIdResult = familyService.findByDocumentId("42");

    // Assert
    verify(fatherRepository).findByDocumentId(eq("42"));
    assertTrue(actualFindByDocumentIdResult.isPresent());
    assertSame(ofResult, actualFindByDocumentIdResult);
  }

  /**
   * Method under test: {@link FamilyService#findByPhone(String)}
   */
  @Test
  void testFindByPhone() {
    // Arrange
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
    Optional<Father> ofResult = Optional.of(father);
    when(fatherRepository.findByPhone(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    Optional<Father> actualFindByPhoneResult = familyService.findByPhone("6625550144");

    // Assert
    verify(fatherRepository).findByPhone(eq("6625550144"));
    assertTrue(actualFindByPhoneResult.isPresent());
    assertSame(ofResult, actualFindByPhoneResult);
  }

}
