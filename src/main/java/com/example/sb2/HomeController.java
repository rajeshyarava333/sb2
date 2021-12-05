package com.example.sb2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private Environment environment;

    @GetMapping(value="/property/{id}")
    public ResponseEntity<Object> getMessage(@PathVariable("id") String id){
        String value=environment.getProperty(id);
        String name="welcome";
        log.info("name {},id {},value {}",name,id,value);
        String response=name+" "+id+" "+value;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
