package com.firstproject.myproject.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "department_entries")
@Data
public class DepartmentEntry {

    @Id
    private ObjectId deptId;
    private String userName;
    private String deptName;


}
