package com.example.dj_case.controller;

import com.example.dj_case.entity.DJ;
import com.example.dj_case.entity.DjSet;
import com.example.dj_case.repository.DjSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/djset")
public class DjSetController {

    private DjSetRepository djSetRepository;

    @Autowired
    public DjSetController(DjSetRepository djSetRepository) {
        this.djSetRepository = djSetRepository;
    }

    @GetMapping("/get/all")
    public List<DjSet> getAllDJ() {
        return (List<DjSet>) djSetRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<DjSet> getId(@PathVariable(name = "id") Long id) {
        return djSetRepository.findById(id);
    }

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DjSet create(@RequestBody final DjSet djSet) throws ValidationException {
        if(djSet.getName() != null && djSet.getDay() != null && djSet.getStage() != null)
            return djSetRepository.saveAndFlush(djSet);
        else throw new ValidationException("DJ Set can not be created.");
    }

    //DELETE
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        djSetRepository.deleteById(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<DJ> update(@RequestBody DjSet djSet) {
        if(djSetRepository.findById(djSet.getId()).isPresent())
            return new ResponseEntity(djSetRepository.save(djSet), HttpStatus.OK);
        else
            return new ResponseEntity("The id doesn't exist of " + djSet, HttpStatus.BAD_REQUEST);
    }
}
