package com.dictionary.example.services;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.repository.EnWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnWordServiceImpl implements EnWordService {

    @Autowired
    private EnWordRepository repository;

    @Override
    public List<EnWord> findAll() {
        return (List<EnWord>) repository.findAll();
    }
}
