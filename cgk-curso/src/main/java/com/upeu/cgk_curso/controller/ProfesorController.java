package com.upeu.cgk_curso.controller;

import com.upeu.cgk_curso.entity.Profesor;
import com.upeu.cgk_curso.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    // Listar todos los profesores
    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores() {
        List<Profesor> profesores = profesorService.listarProfesores();
        return ResponseEntity.ok(profesores);
    }

    // Obtener un profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesor(@PathVariable Long id) {
        return profesorService.obtenerProfesorPorId(id)
                .map(ResponseEntity::ok) // si existe, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // si no, devuelve 404
    }

    // Crear un nuevo profesor
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor guardado = profesorService.guardarProfesor(profesor);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar un profesor existente
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        try {
            Profesor actualizado = profesorService.actualizarProfesor(id, profesor);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
    }

    // Eliminar un profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
