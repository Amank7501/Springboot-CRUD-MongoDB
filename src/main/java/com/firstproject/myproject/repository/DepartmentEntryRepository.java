package com.firstproject.myproject.repository;

import com.firstproject.myproject.entity.DepartmentEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentEntryRepository extends MongoRepository<DepartmentEntry, ObjectId> {
}
