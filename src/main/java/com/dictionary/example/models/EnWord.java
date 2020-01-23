package com.dictionary.example.models;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "en_word")
@AllArgsConstructor
@NoArgsConstructor
public class EnWord {

    public EnWord(String word, String description) {
        this.word = word;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "word")
    private String word;

//    @Column(name = "description")
    private String description;

}
