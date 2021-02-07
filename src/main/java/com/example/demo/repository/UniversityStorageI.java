package com.example.demo.repository;

import com.example.demo.entity.University;

import java.util.List;

public interface UniversityStorageI {

    List<University> findAll();
    University findUniversityById(Integer id);
    void insertUniversity(University university);
}
