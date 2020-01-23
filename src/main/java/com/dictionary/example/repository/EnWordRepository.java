package com.dictionary.example.repository;

import com.dictionary.example.models.EnWord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EnWordRepository extends CrudRepository<EnWord, Long> {

    List<EnWord> findByWord(String word);



}
