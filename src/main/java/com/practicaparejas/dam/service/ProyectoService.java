package com.practicaparejas.dam.service;

import com.practicaparejas.dam.repo.ProyectoRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public List<Proyecto> getAllProyectos() {
        List<Proyecto> result = proyectoRepository.findAll();
/*        if (result.isEmpty()) {

        }*/
        return result;
    }

    public Proyecto addProyecto(Proyecto p) {
        return proyectoRepository.save(p);
    }




}
