package com.upeu.cgk_matricula.service.impl;

import com.upeu.cgk_matricula.entity.Matricula;
import com.upeu.cgk_matricula.repository.MatriculaRepository;
import com.upeu.cgk_matricula.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> obtenerMatriculaPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizarMatricula(Long id, Matricula matricula) {
        return matriculaRepository.findById(id)
                .map(m -> {
                    m.setEstudiante(matricula.getEstudiante());  // Aquí accedemos al objeto complet
                    m.setFechaMatricula(matricula.getFechaMatricula());
                    m.setEstado(matricula.getEstado());
                    m.setNotaFinal(matricula.getNotaFinal());
                    return matriculaRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
    }

    @Override
    public void eliminarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}
