package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.repository.EnWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class EnWordController {

    @Autowired
    private EnWordRepository enWordRepository;

    @GetMapping("/showEnWord")
    public String findAllEnWord(Map<String, Object> model) {

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.put("enWords", enWords);

        return "showEnWord";
    }
}
