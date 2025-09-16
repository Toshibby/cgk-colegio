package com.upeu.cgk_curso.service;

import com.upeu.cgk_curso.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    // Listar todos los cursos
    List<Curso> listarCursos();

    // Obtener un curso por ID
    Optional<Curso> obtenerCursoPorId(Long id);

    // Obtener cursos por categoría
    List<Curso> obtenerCursosPorCategoria(String categoria);

    // Guardar un nuevo curso
    Curso guardarCurso(Curso curso);

    // Actualizar un curso existente
    Curso actualizarCurso(Long id, Curso curso);

    // Eliminar un curso por ID
    void eliminarCurso(Long id);
}
