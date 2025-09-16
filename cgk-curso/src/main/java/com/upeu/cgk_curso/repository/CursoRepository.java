package com.upeu.cgk_curso.repository;

import com.upeu.cgk_curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Buscar cursos por categoría
    List<Curso> findByCategoria(String categoria);

    // Buscar curso por nombre
    Curso findByNombre(String nombre);
}
