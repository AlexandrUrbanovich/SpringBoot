package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.models.RuWord;
import com.dictionary.example.repository.EnWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private EnWordRepository enWordRepository;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        return "welcome";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.put("enWords", enWords);

        return "main";
    }

    @PostMapping("add")
    public String addEnWord(
            @RequestParam String word,
            @RequestParam String description,
            RuWord ruWord, Map<String, Object> model
    ) {

        EnWord enWord = new EnWord(word, description, ruWord);
        enWordRepository.save(enWord);

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.put("enWords", enWords);

         return "main";
    }


    @PostMapping("filter")
    public String filterByWord(@RequestParam String word, Map<String, Object> model) {

        Iterable<EnWord> enWords;

        if(word != null && !word.isEmpty()) {
            enWords = enWordRepository.findByWord(word.trim());
        } else {
            enWords = enWordRepository.findAll();
        }

        model.put("enWords", enWords);
        return "main";
    }

}
