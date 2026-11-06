package com.practicaparejas.dam.service;

import com.practicaparejas.dam.model.Tarea;
import com.practicaparejas.dam.repo.TareaRepository;

import java.util.List;

public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea addTarea(Tarea t) {
        return tareaRepository.save(t);
    }

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Tarea findById(Long id) {
        return tareaRepository.findById(id);
    }





}
