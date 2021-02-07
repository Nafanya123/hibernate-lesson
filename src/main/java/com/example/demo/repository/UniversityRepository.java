package com.example.demo.repository;

import com.example.demo.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    University findUniversityById(Integer id);

    University findUniversityByName(String name);

    @Query(value = "select * from University where id = ?1", nativeQuery = true)
    University findUniversityByNameNativeQuery(Integer id);

}
