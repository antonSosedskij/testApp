package com.example.testapp.controller;

import com.example.testapp.entity.PersonEntity;
import com.example.testapp.exception.PersonNotFoundException;
import com.example.testapp.repository.PersonRepository;
import com.example.testapp.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity addPerson(@RequestBody PersonEntity person){
        try{
            personService.addPerson(person);
            return ResponseEntity.ok().body("Запись добавлена");
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(personService.getAll());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body("(((");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity getPerson(@PathVariable String name){
        try{
            return ResponseEntity.ok(personService.getPerson(name));
        }catch(PersonNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        try{
            return ResponseEntity.ok(personService.deletePerson(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    @PutMapping
    public ResponseEntity deletePerson(@RequestBody PersonEntity person,
                                       @RequestParam String name){
        try{
            return ResponseEntity.ok(personService.updatePerson(person, name));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
