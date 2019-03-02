package com.example.countrycodes.com.example.countrycodes.controller;

import com.example.countrycodes.com.example.countrycodes.com.example.countrycodes.repository.EntryRepository;
import com.example.countrycodes.model.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
@ResponseStatus(HttpStatus.OK)
public class CountryCodesController {

    @Autowired
    private EntryRepository entryRepository;

    private Logger log = LoggerFactory.getLogger(CountryCodesController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Entry> getAll() {
        return entryRepository.findAll();
    }


    @GetMapping("{country}")
    public Optional<Entry> get(@PathVariable Optional<String> country) {
        log.info("Finding code for country: " + country);
        if (!country.isPresent()) {
            log.error("Null country");
            return Optional.ofNullable(new Entry());
        }
        Optional<Entry> entry = entryRepository.findById(country.get());
        return entry;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Entry> add(@RequestBody Optional<Entry> entry) {
        log.info("Adding: " + entry);
        if (!entry.isPresent()) {
            log.error("Invalid input");
            return Optional.ofNullable(new Entry());
        }
        Entry e = entryRepository.save(entry.get());
        return Optional.ofNullable(e);
    }

    @PutMapping
    public void update(@RequestBody Optional<Entry> entry) {
        log.info("Updating: " + entry);

        if (!entry.isPresent()) {
            log.error("Invalid Input");
            return;
        }
        String country = entry.get().getCountry();
        Optional<Entry> e = entryRepository.findById(country);

        if (! e.isPresent()) {
            log.error("Code not found for country: " + country);
        }
        e.get().setCode(entry.get().getCode());
        log.info("Saving: " +  e);
        entryRepository.save(e.get());
    }

    @DeleteMapping("{country}")
    public void delete(@PathVariable Optional<String> country) {
        if (entryRepository.findById(country.get()).isPresent()) {
            log.info("Deleting: " + country);
            entryRepository.deleteById(country.get());
        } else {
            log.info("Unable to delete: " + country);
        }
    }
}
