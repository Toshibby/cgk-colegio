package com.upeu.cgk_curso.service.impl;

import com.upeu.cgk_curso.entity.Curso;
import com.upeu.cgk_curso.repository.CursoRepository;
import com.upeu.cgk_curso.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> obtenerCursosPorCategoria(String categoria) {
        return cursoRepository.findByCategoria(categoria);
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        return cursoRepository.findById(id)
                .map(c -> {
                    c.setNombre(curso.getNombre());
                    c.setDescripcion(curso.getDescripcion());
                    c.setFechaInicio(curso.getFechaInicio());
                    c.setFechaFin(curso.getFechaFin());
                    c.setHorario(curso.getHorario());
                    c.setCupoMaximo(curso.getCupoMaximo());
                    c.setCategoria(curso.getCategoria());
                    c.setProfesor(curso.getProfesor());  // Asignamos el objeto Profesor
                    return cursoRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
