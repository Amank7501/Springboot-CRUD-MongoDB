package com.firstproject.myproject.repository;

import com.firstproject.myproject.entity.JournalEntry;
import com.firstproject.myproject.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
}
