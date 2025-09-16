package com.upeu.cgk_matricula.service;

import com.upeu.cgk_matricula.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    // Listar todos los estudiantes
    List<Estudiante> listarEstudiantes();

    // Obtener un estudiante por ID
    Optional<Estudiante> obtenerEstudiantePorId(Long id);

    // Guardar un nuevo estudiante
    Estudiante guardarEstudiante(Estudiante estudiante);

    // Actualizar un estudiante existente
    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);

    // Eliminar un estudiante por ID
    void eliminarEstudiante(Long id);
}
