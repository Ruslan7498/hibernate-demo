package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Person;
import com.example.hibernatedemo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final DemoRepository repository;

    @Autowired
    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}