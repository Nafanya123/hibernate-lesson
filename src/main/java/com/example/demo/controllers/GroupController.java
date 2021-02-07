package com.example.demo.controllers;

import com.example.demo.entity.Group;
import com.example.demo.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}
