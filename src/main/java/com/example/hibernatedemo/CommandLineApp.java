package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {
    public static final List<String> NAMES = Arrays.asList("Ivan", "Petr", "Oleg", "Roman", "Alexey");
    public static final List<String> SURNAMES = Arrays.asList("Sazonov", "Markov", "Petrov", "Vetrov", "Konev");
    public static final List<String> CITYS = Arrays.asList("Moscow", "Omsk", "Kazan", "Sochi", "Murmansk");
    public static final String UNKNOWN = "unknown";
    public static final int AGE = 60;
    public static final Random random = new Random();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String[] args) throws Exception {
        IntStream.range(0, 50)
                .forEach(i -> {
                    Person person = Person.builder()
                            .name(NAMES.get(random.nextInt(NAMES.size())))
                            .surname(SURNAMES.get(random.nextInt(NAMES.size())))
                            .age(random.nextInt(AGE))
                            .city(CITYS.get(random.nextInt(NAMES.size())))
                            .phoneNumber(UNKNOWN)
                            .build();
                    entityManager.persist(person);
                });
    }
}
