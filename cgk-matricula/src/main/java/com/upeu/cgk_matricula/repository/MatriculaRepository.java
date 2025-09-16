package com.upeu.cgk_matricula.repository;

import com.upeu.cgk_matricula.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // Buscar matriculas por estudiante
    List<Matricula> findByIdEstudiante(Long idEstudiante);

    // Buscar matriculas por curso

    // Si necesitas algún método específico, puedes añadirlo aquí
}
