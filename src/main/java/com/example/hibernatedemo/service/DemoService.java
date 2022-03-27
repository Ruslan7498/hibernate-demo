package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Person;
import com.example.hibernatedemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final PersonRepository personRepository;

    @Autowired
    public DemoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}