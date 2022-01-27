package com.example.testapp.controller;

import com.example.testapp.entity.BirthdayListEntity;
import com.example.testapp.exception.ListNotFoundException;
import com.example.testapp.service.BirthdayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lists")
public class BirthdayListController {

    @Autowired
    private BirthdayListService listService;

    @PostMapping
    public ResponseEntity createList(@RequestBody BirthdayListEntity list){
        try{
            listService.createBirthdayList(list);
            return ResponseEntity.ok().body("Запись добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getBirthdayList(@RequestParam String title){
        try{
            return ResponseEntity.ok(listService.getBirthdayList(title));
        }catch (ListNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
