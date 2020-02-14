package com.dictionary.example.models;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @Column(name = "en_word_id")
    private Long enWordId;

    @Column(name = "word")
    @NotBlank(message = "Please fill the word")
    private String word;

    @Column(name = "description")
    @NotBlank(message = "Please fill the description")
    @Length(max = 255, message = "Description to long (more than 255 chars)")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ruWord_ruWordId")
    private RuWord ruWord;

}
