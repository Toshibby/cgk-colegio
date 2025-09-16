package com.upeu.cgk_curso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false, length = 100, name = "nombre_curso")
    private String nombre;

    @Column(nullable = false, length = 255, name = "descripcion_curso")
    private String descripcion;

    @Column(nullable = false, name = "fecha_inicio_curso")
    private LocalDate fechaInicio;

    @Column(nullable = false, name = "fecha_fin_curso")
    private LocalDate fechaFin;

    @Column(nullable = false, length = 50, name = "horario_curso")
    private String horario;

    @Column(nullable = false, name = "cupo_maximo_curso")
    private Integer cupoMaximo;

    @Column(nullable = false, length = 50, name = "categoria_curso")
    private String categoria;

    // Relación Many-to-One con Profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

}
