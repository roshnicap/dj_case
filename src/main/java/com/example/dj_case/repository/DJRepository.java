package com.example.dj_case.repository;

import com.example.dj_case.entity.DJ;
import org.springframework.data.repository.CrudRepository;

public interface DJRepository extends CrudRepository<DJ, Integer> {

    //getAllDJ
    //getDJbyId(int Id)
    //updateDJ(int Id)
}
