package com.example.demo.controllers;

import com.example.demo.entity.University;
import com.example.demo.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/getAllUniversity")
    public List<University> getAllUniversity() {
        return universityService.getAll();
    }

    @PostMapping("/getUniversity")
    public University getUniversityById(@RequestBody University university) {
        return universityService.getUniversityById(university);
    }

    @PutMapping("/addUniversity")
    public List<University> addUniversity(@RequestBody University university) {
        return universityService.saveOrUpdateUniversity(university);
    }

    @PatchMapping("/pathUniversity")
    public List<University> pathUniversity(@RequestBody University university) {
        return universityService.saveOrUpdateUniversity(university);
    }

    @PostMapping("/updateUniversity")
    public List<University> updateUniversity(@RequestBody University university) {
        return universityService.saveOrUpdateUniversity(university);
    }

    @PostMapping("/deleteUniversity")
    public List<University> deleteUniversity(@RequestBody University university) {
        return universityService.deleteUniversity(university);
    }

    @GetMapping("/getAllUniversityH")
    public List<University> getAllUniversityH() {
        return universityService.getAllH();
    }

    @PostMapping("/getUniversityH")
    public University getUniversityByIdH(@RequestBody University university) {
        return universityService.getUniversityByIdH(university);
    }

    @PutMapping("/addUniversityH")
    public List<University> addUniversityH(@RequestBody University university) {
        return universityService.addUniversityH(university);
    }

    @PostMapping("/deleteUniversityH")
    public List<University> deleteUniversityH(@RequestBody University university) {
        return universityService.deleteUniversityH(university);
    }

}
