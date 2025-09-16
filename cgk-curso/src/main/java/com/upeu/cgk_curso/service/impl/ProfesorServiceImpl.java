package com.upeu.cgk_curso.service.impl;

import com.upeu.cgk_curso.entity.Profesor;
import com.upeu.cgk_curso.repository.ProfesorRepository;
import com.upeu.cgk_curso.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Optional<Profesor> obtenerProfesorPorEmail(String email) {
        return Optional.ofNullable(profesorRepository.findByEmail(email));
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        return profesorRepository.findById(id)
                .map(p -> {
                    p.setNombre(profesor.getNombre());
                    p.setApellido(profesor.getApellido());
                    p.setEmail(profesor.getEmail());
                    p.setTelefono(profesor.getTelefono());
                    return profesorRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    @Override
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
