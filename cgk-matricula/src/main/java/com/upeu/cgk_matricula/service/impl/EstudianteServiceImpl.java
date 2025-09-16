package com.upeu.cgk_matricula.service.impl;

import com.upeu.cgk_matricula.entity.Estudiante;
import com.upeu.cgk_matricula.repository.EstudianteRepository;
import com.upeu.cgk_matricula.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        return estudianteRepository.findById(id)
                .map(e -> {
                    e.setNombre(estudiante.getNombre());
                    e.setApellido(estudiante.getApellido());
                    e.setEmail(estudiante.getEmail());
                    e.setTelefono(estudiante.getTelefono());
                    e.setFechaNacimiento(estudiante.getFechaNacimiento());
                    e.setDireccion(estudiante.getDireccion());
                    return estudianteRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
