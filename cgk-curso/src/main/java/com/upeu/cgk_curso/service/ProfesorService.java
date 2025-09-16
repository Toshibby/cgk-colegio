package com.upeu.cgk_curso.service;

import com.upeu.cgk_curso.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {

    // Listar todos los profesores
    List<Profesor> listarProfesores();

    // Obtener un profesor por ID
    Optional<Profesor> obtenerProfesorPorId(Long id);

    // Obtener un profesor por email
    Optional<Profesor> obtenerProfesorPorEmail(String email);

    // Guardar un nuevo profesor
    Profesor guardarProfesor(Profesor profesor);

    // Actualizar un profesor existente
    Profesor actualizarProfesor(Long id, Profesor profesor);

    // Eliminar un profesor por ID
    void eliminarProfesor(Long id);
}
