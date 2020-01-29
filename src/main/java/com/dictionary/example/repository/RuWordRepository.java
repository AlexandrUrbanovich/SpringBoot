package com.dictionary.example.repository;

import com.dictionary.example.models.RuWord;
import org.springframework.data.repository.CrudRepository;

public interface RuWordRepository extends CrudRepository<RuWord, Long> {
}
