package com.practicaparejas.dam.repo;

import com.practicaparejas.dam.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
