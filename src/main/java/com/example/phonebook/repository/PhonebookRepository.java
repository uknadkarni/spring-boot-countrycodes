package com.example.phonebook.repository;

import com.example.phonebook.model.Phonebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonebookRepository extends CrudRepository<Phonebook, String> {
}
