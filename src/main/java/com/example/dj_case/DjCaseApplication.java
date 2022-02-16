package com.example.dj_case;

import com.example.dj_case.repository.DJRepository;
import com.example.dj_case.repository.SetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dj_case.entity.DJ;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DjCaseApplication {

    private static final Logger log = LoggerFactory.getLogger(DjCaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DjCaseApplication.class, args);
        System.out.println("Hello World");
    }

    @Bean
    public CommandLineRunner data(DJRepository dj_repository, SetRepository set_repository) {
        return (args) -> {
            dj_repository.save(new DJ(1,"Martin", 25, "house" ));
            dj_repository.save(new DJ(2,"David", 40, "disco" ));
            dj_repository.save(new DJ(3,"Nikita", 30, "hiphop" ));

            for (DJ dj : dj_repository.findAll()) {
                log.info("The DJ is  : " + dj.toString());
            }
        };
    }

}
