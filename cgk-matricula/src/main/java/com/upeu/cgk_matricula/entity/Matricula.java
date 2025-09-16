package com.upeu.cgk_matricula.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    // Relación ManyToOne con Estudiante
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;  // Asegúrate de que "estudiante" sea un objeto completo, no solo un ID

    // Relación ManyToOne con Curso

    private Long cursoid;  // Asegúrate de que "curso" sea un objeto completo, no solo un ID

    @Column(nullable = false, name = "fecha_matricula")
    private LocalDate fechaMatricula;

    @Column(nullable = false, length = 20, name = "estado_matricula")
    private String estado;

    @Column(name = "nota_final")
    private Double notaFinal;
}
