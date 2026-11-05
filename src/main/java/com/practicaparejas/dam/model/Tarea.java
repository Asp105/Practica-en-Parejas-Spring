package com.practicaparejas.dam.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
@Setter
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @ToString.Exclude
    private Proyecto proyecto;

    // Regla A: borrar tarea -> borra comentarios
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Comentario> comentarios = new ArrayList<>();

    // Regla B: sin cascade REMOVE, las etiquetas se conservan
    @ManyToMany
    @JoinTable(
            name = "tarea_etiqueta",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    @ToString.Exclude
    private Set<Etiqueta> etiquetas = new HashSet<>();

    public Tarea(String titulo, EstadoTarea estado) {
        this.titulo = titulo;
        this.estado = estado;
    }

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
        comentario.setTarea(this);
    }

    public void removeComentario(Comentario comentario) {
        comentarios.remove(comentario);
        comentario.setTarea(null);
    }

    public void addEtiqueta(Etiqueta etiqueta) {
        etiquetas.add(etiqueta);
    }

    public void removeEtiqueta(Etiqueta etiqueta) {
        etiquetas.remove(etiqueta);
    }

}
