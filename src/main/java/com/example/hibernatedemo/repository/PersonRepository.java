package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCity(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    List<Person> findByNameAndSurname(String name, String surname);
}
