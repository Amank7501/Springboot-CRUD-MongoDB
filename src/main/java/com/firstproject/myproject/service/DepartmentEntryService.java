package com.firstproject.myproject.service;

import com.firstproject.myproject.entity.DepartmentEntry;
import com.firstproject.myproject.repository.DepartmentEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class DepartmentEntryService {

    @Autowired
    private DepartmentEntryRepository departmentEntryRepository;

    public void saveEntry(DepartmentEntry departmentEntry){
        try {
            departmentEntryRepository.save(departmentEntry);
        }catch(Exception e){
            log.error("Exception ", e);
        }

    }

    public List<DepartmentEntry> getAll(){
        return departmentEntryRepository.findAll();}

    public Optional<DepartmentEntry> getEntryByID(ObjectId deptId){
        return departmentEntryRepository.findById(deptId);
    }

    public void deleteEntryById(ObjectId deptId){
        departmentEntryRepository.deleteById(deptId);
    }

}
