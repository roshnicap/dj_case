package com.example.dj_case.repository;

import com.example.dj_case.entity.DJ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DJRepository extends JpaRepository<DJ, Integer> {

   // DJ getId(Integer id);
}
