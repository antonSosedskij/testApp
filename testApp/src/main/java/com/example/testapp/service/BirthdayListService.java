package com.example.testapp.service;

import com.example.testapp.entity.BirthdayListEntity;
import com.example.testapp.exception.ListNotFoundException;
import com.example.testapp.repository.BirthdayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirthdayListService {

    @Autowired
    private BirthdayListRepository listRepository;

    public BirthdayListEntity createBirthdayList(BirthdayListEntity birthdayList){
        return listRepository.save(birthdayList);
    }

    public BirthdayListEntity getBirthdayList(String title) throws ListNotFoundException {
        BirthdayListEntity birthdayList = listRepository.findByTitle(title);
        if (birthdayList == null){
            throw new ListNotFoundException("Такого списка не существует");
        }
        return birthdayList;
    }

}


