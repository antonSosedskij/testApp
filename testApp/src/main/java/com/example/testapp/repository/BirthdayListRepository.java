package com.example.testapp.repository;

import com.example.testapp.entity.BirthdayListEntity;
import org.springframework.data.repository.CrudRepository;

public interface BirthdayListRepository extends CrudRepository<BirthdayListEntity, Long> {
     BirthdayListEntity findByTitle(String title);
}
