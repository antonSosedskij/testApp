package com.example.testapp.repository;

import com.example.testapp.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    PersonEntity findByName(String name);

}
