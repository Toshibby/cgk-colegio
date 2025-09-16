package com.upeu.cgk_curso.repository;

import com.upeu.cgk_curso.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // Buscar profesor por email
    Profesor findByEmail(String email);
}
