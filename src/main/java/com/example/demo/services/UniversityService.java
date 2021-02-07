package com.example.demo.services;

import com.example.demo.UniversityStorage;
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityStorage universityRepositoryCustomImp;

    //TODO - использование Repository
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    public University getUniversityById(University university) {
        return universityRepository.findUniversityByNameNativeQuery(university.getId());
    }

    public List<University> saveOrUpdateUniversity(University university) {
        try {
            universityRepository.save(university);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return getAll();
    }

    public List<University> deleteUniversity(University university) {
        try {
            universityRepository.delete(university);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return getAllH();
    }

    //TODO - использование без Repository

    public List<University> getAllH() {
        return universityRepositoryCustomImp.findAll();
    }

    public University getUniversityByIdH(University university) {
        return universityRepositoryCustomImp.findUniversityById(university.getId());
    }

    public List<University> addUniversityH(University university) {
        try {
            universityRepositoryCustomImp.insertUniversity(university);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return getAllH();
    }

    public List<University> deleteUniversityH(University university) {
        try {
            universityRepositoryCustomImp.delete(university);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return getAllH();
    }

}
