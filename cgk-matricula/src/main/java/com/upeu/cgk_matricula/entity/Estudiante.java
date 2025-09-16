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
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(nullable = false, length = 100, name = "nombre_estudiante")
    private String nombre;

    @Column(nullable = false, length = 100, name = "apellido_estudiante")
    private String apellido;

    @Column(unique = true, length = 150, name = "email_estudiante")
    private String email;

    @Column(length = 15, name = "telefono_estudiante")
    private String telefono;

    @Column(nullable = false, name = "fecha_nacimiento_estudiante")
    private LocalDate fechaNacimiento;

    @Column(length = 255, name = "direccion_estudiante")
    private String direccion;
}
