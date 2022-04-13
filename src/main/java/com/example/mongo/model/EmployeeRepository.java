package com.example.mongo.model;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
