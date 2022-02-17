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

//    @Bean
//    public Runner getRunner() {
//        return new Runner();
//    }
    @Bean
    public CommandLineRunner data(DJRepository djRepository) {
        return (args) -> {
            djRepository.save(new DJ("Martin", 25, "house" ));
            djRepository.save(new DJ("David", 40, "disco" ));
            djRepository.save(new DJ("Nikita", 30, "hiphop" ));

            //fetch all DJs
            log.info("all DJs found with findAll():");
            for (DJ dj : djRepository.findAll()) {
                log.info("The DJ is  : " + dj.toString());
            }
            log.info("");
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Hello From CommandLineRunner");
//    }
}
