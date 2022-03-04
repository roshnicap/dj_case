package com.example.dj_case.controller;

import com.example.dj_case.entity.DJ;
import com.example.dj_case.repository.DJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dj")
public class DJController {

    private DJRepository djRepository;

    @Autowired
    public DJController(DJRepository djRepository){
        this.djRepository = djRepository;
    }

    //READ
    @GetMapping("/get/all")
    public List<DJ> getAllDJ(){
        return (List<DJ>) djRepository.findAll();
    }

    //READ
    @GetMapping("/get/{id}")
    public Optional<DJ> getId (@PathVariable(name="id") Long id){
        return djRepository.findById(id);
    }

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DJ create(@RequestBody DJ dj) throws ValidationException {
        if(dj.getName() != null && dj.getAge() != null && dj.getStyle() != null)
            return djRepository.saveAndFlush(dj);
        else throw new ValidationException("DJ can not be created.");
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity exceptionHandler(ValidationException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //DELETE
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        djRepository.deleteById(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<DJ> update(@RequestBody DJ dj) {
        if(djRepository.findById(dj.getId()).isPresent())
            return new ResponseEntity(djRepository.save(dj), HttpStatus.OK);
        else
            return new ResponseEntity(dj, HttpStatus.BAD_REQUEST);
    }
}
