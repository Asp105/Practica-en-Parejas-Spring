package com.practicaparejas.dam.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    @ToString.Exclude
    private Tarea tarea;

    public Comentario(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }
}
