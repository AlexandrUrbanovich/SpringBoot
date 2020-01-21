package com.dictionary.example.repository;

import com.dictionary.example.models.EnWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnWordRepository extends CrudRepository<EnWord, Long> {

    List<EnWord> findByWord(String word);

}
