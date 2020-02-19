package com.dictionary.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "ru_word")
@AllArgsConstructor
@NoArgsConstructor
public class RuWord {

    public RuWord(String translate) {
        this.translate = translate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ru_word_id")
    private Long id;

    @Column(name = "translate")
    @NotBlank(message = "Please fill the translate")
    private String translate;

    @OneToOne(mappedBy = "ruWord")
    private EnWord enWord;

}
