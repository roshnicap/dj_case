package com.example.dj_case;

import com.example.dj_case.entity.DjSet;
import com.example.dj_case.repository.DJRepository;
import com.example.dj_case.repository.DjSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dj_case.entity.DJ;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DjCaseApplication {

    private static final Logger log = LoggerFactory.getLogger(DjCaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DjCaseApplication.class, args);
        System.out.println("Hello World");
    }

    DJ martin = new DJ("Martin", 25, "house" );


    @Bean
    public CommandLineRunner demo(DJRepository djRepository, DjSetRepository djSetRepository) {
        return (args) -> {
            djRepository.save(martin);
            djRepository.save(new DJ("David", 40, "disco" ));
            djRepository.save(new DJ("Nikita", 30, "hiphop"));
            djSetRepository.save(new DjSet("House", LocalDate.of(2022,6,1),"Outside stage", LocalTime.of(17,30), LocalTime.of(20,30),martin));
            djSetRepository.save(new DjSet("Techno", LocalDate.of(2022,6,2),"Inside stage", LocalTime.of(15,0), LocalTime.of(19,30),martin));
            djSetRepository.save(new DjSet("Hard", LocalDate.of(2022,6,3),"Rooftop stage", LocalTime.of(16,0), LocalTime.of(18,30),martin));

            //fetch all DJs
            log.info("all DJs found with findAll():");
            for (DJ dj : djRepository.findAll()) {
                log.info("The DJ is  : " + dj.toString());
            }
//            //fetch all Sets
            log.info("all Sets which DJ's can play, findAll():");
            for (DjSet djSet : djSetRepository.findAll()) {
                log.info("The set is " + djSet.getName());
            }
        };
    }
}
