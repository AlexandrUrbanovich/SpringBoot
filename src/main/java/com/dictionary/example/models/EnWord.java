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

    public EnWord(String word, String description, RuWord ruWord) {
        this.word = word;
        this.description = description;
        this.ruWord = ruWord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ru_word_id")
    private RuWord ruWord;

}
