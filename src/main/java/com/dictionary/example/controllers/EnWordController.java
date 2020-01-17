package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.repository.EnWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EnWordController {

    @Autowired
    private EnWordRepository enWordRepository;

    @GetMapping("/showEnWord")
    public String findAllEnWord(Model model) {

        Iterable<EnWord> enWords = enWordRepository.findAll();
//        model.addAttribute("enWord", enWord);

        return String.valueOf(enWords);
    }
}
