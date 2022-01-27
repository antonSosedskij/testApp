package com.example.testapp.service;

import com.example.testapp.entity.BirthdayListEntity;
import com.example.testapp.entity.PersonEntity;
import com.example.testapp.exception.PersonNotFoundException;
import com.example.testapp.model.Person;
import com.example.testapp.repository.BirthdayListRepository;
import com.example.testapp.repository.PersonRepository;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BirthdayListRepository birthdayListRepository;

    public PersonEntity addPerson (PersonEntity person){
        return personRepository.save(person);
    }

    public Iterable<PersonEntity> getAll(){
        Iterable<PersonEntity> entities = personRepository.findAll();
        return entities;
    }

    public Person getPerson(String name) throws PersonNotFoundException{
        PersonEntity person = personRepository.findByName(name);
        if (person == null){
            throw new PersonNotFoundException("Не найдено");
        }
        return Person.toModel(person);
    }

    public Long deletePerson(Long id){
        personRepository.deleteById(id);
        return id;
    }

    public PersonEntity updatePerson(PersonEntity p, String name){
        PersonEntity person = personRepository.findByName(name);
        person.setBirthDay(p.getBirthDay());

        return person;
    }
}

