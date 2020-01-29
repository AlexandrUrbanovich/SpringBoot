package com.dictionary.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ru_word")
@AllArgsConstructor
@NoArgsConstructor
public class RuWord {

    public RuWord(String word) {
        this.word = word;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ru_word_id")
    private Long id;

    @Column(name = "word")
    private String word;

    @OneToOne(mappedBy = "ruWord")
    private EnWord enWord;

}
