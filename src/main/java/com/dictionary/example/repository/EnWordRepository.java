package com.dictionary.example.repository;

import com.dictionary.example.models.EnWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnWordRepository extends CrudRepository<EnWord, Long> {

}
