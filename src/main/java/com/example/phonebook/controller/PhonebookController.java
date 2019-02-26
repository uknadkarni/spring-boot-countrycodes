package com.example.phonebook.controller;

import com.example.phonebook.model.Phonebook;
import com.example.phonebook.repository.PhonebookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/entry")
//@ResponseStatus(HttpStatus.OK)
public class PhonebookController {

    @Autowired
    private PhonebookRepository phonebookRepository;

    private static final Logger log = LoggerFactory.getLogger(PhonebookController.class);

    @GetMapping
    public Iterable<Phonebook> index() {
        return phonebookRepository.findAll();
    }


    @GetMapping("{name}")
    public Phonebook show(@PathVariable String name) {
        if (name.isEmpty()) {
            log.debug("Empty name");
            Phonebook phonebook = new Phonebook();
            return phonebook;
        }
        Optional<Phonebook> p = phonebookRepository.findById(name);
        log.info("Found: " + p);
        if (p.isPresent()) {
            return p.get();
        }
        return new Phonebook();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Phonebook pb) {
        log.info("Adding: " + pb);
        Phonebook save = phonebookRepository.save(pb);
    }

    @PutMapping("{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable String name,
                       @RequestBody Phonebook pb) {
        if (!phonebookRepository.existsById(name)) {
            log.error("Name " + name + " not found");
        }
        log.info("Updating: " + name + " " + pb);
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable String name) {
        if (!phonebookRepository.existsById(name)) {
            log.error(name + " not found");
        }
        phonebookRepository.deleteById(name);
    }
}
