package com.example.dj_case.repository;

import com.example.dj_case.entity.DJ;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DJRepository extends CrudRepository<DJ, Integer> {

    List<DJ> findAllByName(String name);

    Optional<DJ> findById(Integer id);
    //getAllDJ
    //getDJbyId(int Id)
    //updateDJ(int Id)
}
