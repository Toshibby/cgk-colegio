package com.upeu.cgk_curso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(nullable = false, length = 100, name = "nombre_profesor")
    private String nombre;

    @Column(nullable = false, length = 100, name = "apellido_profesor")
    private String apellido;

    @Column(nullable = false, unique = true, length = 150, name = "email_profesor")
    private String email;

    @Column(length = 15, name = "telefono_profesor")
    private String telefono;

    // Relación inversa, un profesor puede tener muchos cursos
    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;
}
