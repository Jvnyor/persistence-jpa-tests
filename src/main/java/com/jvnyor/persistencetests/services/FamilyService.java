package com.jvnyor.persistencetests.services;

import com.jvnyor.persistencetests.entities.Father;
import com.jvnyor.persistencetests.entities.Grandfather;
import com.jvnyor.persistencetests.entities.Son;
import com.jvnyor.persistencetests.entities.Thing;
import com.jvnyor.persistencetests.repositories.FatherRepository;
import com.jvnyor.persistencetests.repositories.GrandfatherRepository;
import com.jvnyor.persistencetests.repositories.SonRepository;
import com.jvnyor.persistencetests.repositories.ThingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@Transactional
public class FamilyService {
    private final GrandfatherRepository grandfatherRepository;
    private final FatherRepository fatherRepository;
    private final SonRepository sonRepository;
    private final ThingRepository thingRepository;

    public FamilyService(GrandfatherRepository grandfatherRepository,
                         FatherRepository fatherRepository,
                         SonRepository sonRepository,
                         ThingRepository thingRepository) {
        this.grandfatherRepository = grandfatherRepository;
        this.fatherRepository = fatherRepository;
        this.sonRepository = sonRepository;
        this.thingRepository = thingRepository;
    }

    @Transactional(readOnly = true)
    public long getAllThingsCount() {
        return thingRepository.count();
    }

    @Transactional(readOnly = true)
    public long getAllGrandfathersCount() {
        return grandfatherRepository.count();
    }

    @Transactional(readOnly = true)
    public long getAllFathersCount() {
        return fatherRepository.count();
    }

    @Transactional(readOnly = true)
    public long getAllSonsCount() {
        return sonRepository.count();
    }

    public void saveFamily(Grandfather grandfather, Father father, Son son, Set<Thing> things) {
        var grandfatherSaved = saveGrandFather(grandfather);
        var fatherSaved = saveFather(father, grandfatherSaved);
        var sonSaved = saveSon(son, fatherSaved);
        saveThings(things, grandfatherSaved, fatherSaved, sonSaved);
    }

    public Grandfather saveGrandFather(Grandfather grandfather) {
//        grandfather.addThings(things);
        var grandfatherSaved = grandfatherRepository.save(grandfather);
        log.info("Grandfather: {}", grandfatherSaved);
        log.info("Grandfather things: {}", grandfatherSaved.getThings());
        return grandfatherSaved;
    }

    public Father saveFather(Father father, Grandfather grandfather) {
        father.setGrandfather(grandfather);
//        father.addThings(grandfather.getThings());
        var fatherSaved = fatherRepository.save(father);
        log.info("Father: {}", fatherSaved);
        log.info("Father things: {}", fatherSaved.getThings());
        return fatherSaved;
    }

    public Son saveSon(Son son, Father father) {
        son.setFather(father);
//        son.addThings(father.getThings());
        var sonSaved = sonRepository.save(son);
        log.info("Son: {}", sonSaved);
        log.info("Son things: {}", sonSaved.getThings());
        return sonSaved;
    }

    public void saveThings(Set<Thing> things, Grandfather grandfather, Father father, Son son) {
        for (var thing : things) {
            thing.setGrandfather(grandfather);
            thing.setFather(father);
            thing.setSon(son);
        }
        var thingsSaved = thingRepository.saveAll(things);
        log.info("Things saved: {}", thingsSaved);
    }

    @Transactional(readOnly = true)
    public Grandfather findGrandfatherById(Long id) {
        return grandfatherRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Father findFatherById(Long id) {
        return fatherRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Son findSonById(Long id) {
        return sonRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Set<Thing> findThingsByFamilyIds(Long id, Long grandFatherId, Long fatherId, Long sonId) {
        return thingRepository.findByIdAndGrandfather_IdAndFather_IdAndSon_Id(id, grandFatherId, fatherId, sonId);
    }

    @Transactional(readOnly = true)
    public Optional<Father> findByDocumentId(String documentId) {
        var byDocumentId = fatherRepository.findByDocumentId(documentId);
        log.info("Father by document id: {}, exists: {}", documentId, byDocumentId.isPresent());
        return byDocumentId;
    }

    @Transactional(readOnly = true)
    public Optional<Father> findByPhone(String phone) {
        var byPhone = fatherRepository.findByPhone(phone);
        log.info("Father by phone: {}, exists: {}", phone, byPhone.isPresent());
        return byPhone;
    }
}
