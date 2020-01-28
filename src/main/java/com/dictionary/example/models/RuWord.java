package com.dictionary.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ru_Word")
@AllArgsConstructor
@NoArgsConstructor
public class RuWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private EnWord enWord;

}
