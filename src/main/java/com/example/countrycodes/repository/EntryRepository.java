package com.example.countrycodes.repository;

import com.example.countrycodes.model.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, String> {
}
