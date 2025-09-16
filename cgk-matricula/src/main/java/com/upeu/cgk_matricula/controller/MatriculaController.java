package com.upeu.cgk_matricula.controller;

import com.upeu.cgk_matricula.entity.Matricula;
import com.upeu.cgk_matricula.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    // Listar todas las matrículas
    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        List<Matricula> matriculas = matriculaService.listarMatriculas();
        return ResponseEntity.ok(matriculas);
    }

    // Obtener una matrícula por ID
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerMatricula(@PathVariable Long id) {
        return matriculaService.obtenerMatriculaPorId(id)
                .map(ResponseEntity::ok)  // Si existe, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());  // Si no, devuelve 404
    }

    // Crear una nueva matrícula
    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
        Matricula guardada = matriculaService.guardarMatricula(matricula);
        return ResponseEntity.ok(guardada);
    }

    // Actualizar una matrícula existente
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        try {
            Matricula actualizada = matriculaService.actualizarMatricula(id, matricula);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // 404 si no existe
        }
    }

    // Eliminar una matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {
        matriculaService.eliminarMatricula(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }
}
