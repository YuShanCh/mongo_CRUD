package com.example.mongo.controller;


import com.example.mongo.model.Employee;
import com.example.mongo.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

//    @Autowired
//    private EmployeeRepository employeeRepository;

    final private EmployeeRepository employeeRepository;
    final private MongoTemplate mongoTemplate;

    public EmployeeController(EmployeeRepository employeeRepository, MongoTemplate mongoTemplate) {
        this.employeeRepository = employeeRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/saveData")
    public void saveData(@RequestBody List<Employee> employees){
        employeeRepository.saveAll(employees);
    }

    @GetMapping("/findallemployees")
    public List<Employee> findallemployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/findempphone")
    public  List<Employee> findempphone(@RequestParam String phone){
        Query query = new Query();
        query.addCriteria(Criteria.where("phone").regex(phone));
        List<Employee> empphone = mongoTemplate.find(query, Employee.class);
        return empphone;
    }

    @GetMapping("/findempphonepath/{phone}")
    public  List<Employee> findempphonepath(@PathVariable String phone){
        Query query = new Query();
        query.addCriteria(Criteria.where("phone").regex(phone));
        List<Employee> empphone = mongoTemplate.find(query, Employee.class);
        return empphone;
    }



}
