package com.dictionary.example.repository;

import com.dictionary.example.models.EnWord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface EnWordRepository extends CrudRepository<EnWord, Long> {

    List<EnWord> findByWord(String word);

    Optional<EnWord> findById(Long id);

}
