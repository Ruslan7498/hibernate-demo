package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DemoRepository {

    private final EntityManager entityManager;

    @Autowired
    public DemoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :city", Person.class);
        query.setParameter("city", city);
        List<Person> resultList = query.getResultList();
        return resultList;
    }
}