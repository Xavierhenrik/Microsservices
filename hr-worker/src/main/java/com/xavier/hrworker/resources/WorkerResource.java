package com.xavier.hrworker.resources;

import com.xavier.hrworker.entities.Worker;
import com.xavier.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private  WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> FindAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }
    @GetMapping(value = "/{id}")
    public Worker FindById(@PathVariable long id) {
        Worker worker = repository.findById(1L).get();
        return ResponseEntity.ok(worker).getBody();
    }
}
