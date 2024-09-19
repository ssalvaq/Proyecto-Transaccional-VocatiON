package com.scv.service.impl;

import com.scv.model.entity.Estudiante;
import com.scv.repository.EstudianteRepository;
import com.scv.service.AdminEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminEstudianteServiceImpl implements AdminEstudianteService {
    private final EstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Estudiante> paginate(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante not found "));
    }

    @Transactional
    @Override
    public Estudiante create(Estudiante estudiante) {
        estudiante.setCreatedAt(LocalDateTime.now());
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    @Override
    public Estudiante update(Integer id, Estudiante updateEstudiante) {
        Estudiante estudianteFromDb = findById(id);
        estudianteFromDb.setNivelAcademico(updateEstudiante.getNivelAcademico());
        estudianteFromDb.setIntereses(updateEstudiante.getIntereses());
        estudianteFromDb.setUpdatedAt(LocalDateTime.now());
        return estudianteRepository.save(estudianteFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Estudiante estudiante = findById(id);
        estudianteRepository.delete(estudiante);
    }
}
