package com.practicaparejas.dam.service;

import com.practicaparejas.dam.model.Proyecto;
import com.practicaparejas.dam.repo.ProyectoRepository;

import java.util.List;

public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto addProyecto(Proyecto p) {
        return proyectoRepository.save(p);
    }




}
