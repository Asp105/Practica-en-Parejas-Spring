package com.practicaparejas.dam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Tarea> tareas = new ArrayList<>();

    public Proyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
        tarea.setProyecto(this);
    }

    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
        tarea.setProyecto(null);
    }
}

