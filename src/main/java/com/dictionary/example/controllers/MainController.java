package com.dictionary.example.controllers;

import com.dictionary.example.models.EnWord;
import com.dictionary.example.models.RuWord;
import com.dictionary.example.repository.EnWordRepository;
import com.dictionary.example.repository.RuWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
            @Valid EnWord enWord,
            BindingResult bindingResult,
            @Valid RuWord ruWord,
            BindingResult result,
            Model model
    ) {

        if(bindingResult.hasErrors() || result.hasErrors()) {
            Map<String, String> errorsMapBindingResult = ControllerUtils.getErrors(bindingResult);
            Map<String, String> errorsMapResult = ControllerUtils.getErrors(result);

            model.mergeAttributes(errorsMapBindingResult);
            model.mergeAttributes(errorsMapResult);

            enWord.setRuWord(ruWord);
            model.addAttribute("enWord", enWord);
        } else {

            model.addAttribute("enWord", null);

            enWord.setRuWord(ruWord);
            enWordRepository.save(enWord);
        }

        Iterable<EnWord> enWords = enWordRepository.findAll();
        model.addAttribute("enWords", enWords);

        return "main";
    }


}
