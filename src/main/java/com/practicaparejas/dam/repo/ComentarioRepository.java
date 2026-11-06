package com.practicaparejas.dam.repo;

import com.practicaparejas.dam.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
