package com.firstproject.myproject.controllers;

import com.firstproject.myproject.entity.DepartmentEntry;
import com.firstproject.myproject.repository.DepartmentEntryRepository;
import com.firstproject.myproject.service.DepartmentEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentEntryService departmentEntryService;

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        List<DepartmentEntry> allEntry = departmentEntryService.getAll();
        if(allEntry != null){
            return new ResponseEntity<>(allEntry, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentEntry> createEntry(@RequestBody DepartmentEntry myEntry){
        try {
            departmentEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{deptId}")
    public ResponseEntity<DepartmentEntry> getDeptById(@PathVariable ObjectId deptId){
        Optional<DepartmentEntry> departmentEntry= departmentEntryService.getEntryByID(deptId);
        if(departmentEntry.isPresent()) {
            return new ResponseEntity<>(departmentEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/id/{deptId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId deptId){
        departmentEntryService.deleteEntryById(deptId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{deptId}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId deptId, @RequestBody DepartmentEntry newEntry){
        DepartmentEntry oldEntry = departmentEntryService.getEntryByID(deptId).orElse(null);
        if(oldEntry!= null){
            oldEntry.setUserName(newEntry.getUserName()!=null && !newEntry.getUserName().equals("")?newEntry.getUserName():oldEntry.getUserName());
            oldEntry.setDeptName(newEntry.getDeptName()!=null && !newEntry.getDeptName().equals("")? newEntry.getDeptName():oldEntry.getDeptName());
            departmentEntryService.saveEntry(oldEntry);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
