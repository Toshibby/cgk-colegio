package com.upeu.cgk_matricula.service;

import com.upeu.cgk_matricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {

    // Listar todas las matrículas
    List<Matricula> listarMatriculas();

    // Obtener una matrícula por ID
    Optional<Matricula> obtenerMatriculaPorId(Long id);

    // Guardar una nueva matrícula
    Matricula guardarMatricula(Matricula matricula);

    // Actualizar una matrícula existente
    Matricula actualizarMatricula(Long id, Matricula matricula);

    // Eliminar una matrícula por ID
    void eliminarMatricula(Long id);
}
