package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.repository.EnWordRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping()
    public String findAllEnWordOnMain(Map<String, Object> model) {
        return "main";
    }

    @PostMapping
    public String addEnWord(@RequestParam String word, @RequestParam String description, Map<String, Object> model) {

        EnWord enWord = new EnWord(word, description);
        enWordRepository.save(enWord);

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.put("enWords", enWords);

        return "main";
    }


    @PostMapping("filter")
    public String filterByWord(@RequestParam String filter, Map<String, Object> model) {

        Iterable<EnWord> enWords;

        if(filter != null && !filter.isEmpty()) {
            enWords = enWordRepository.findByWord(filter);
        } else {
            enWords = enWordRepository.findAll();
        }

        model.put("enWords", enWords);
        return "main";
    }

}
