package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.models.RuWord;
import com.dictionary.example.repository.EnWordRepository;
import com.dictionary.example.repository.RuWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private EnWordRepository enWordRepository;
    @Autowired
    private RuWordRepository ruWordRepository;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        return "welcome";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<EnWord> enWords = enWordRepository.findAll();

        if(filter != null && !filter.isEmpty()) {
            enWords = enWordRepository.findByWord(filter.trim());
        } else {
            enWords = enWordRepository.findAll();
        }

        model.addAttribute("enWords", enWords);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("add")
    public String addEnWord(
            @RequestParam String word,
            @RequestParam String description,
            @RequestParam String translate, Map<String, Object> model
    ) {

        RuWord ruWord = new RuWord();
        ruWord.setWord(translate);

        EnWord enWord = new EnWord(word, description);
        enWord.setRuWord(ruWord);

        enWordRepository.save(enWord);

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.put("enWords", enWords);

        return "main";
    }


}
