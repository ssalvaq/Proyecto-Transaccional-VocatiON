package com.scv.service;

import com.scv.model.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminEstudianteService {
    List<Estudiante> getAll();
    Page<Estudiante> paginate(Pageable pageable);
    Estudiante findById(Integer id);
    Estudiante create(Estudiante estudiante);
    Estudiante update(Integer id, Estudiante updateEstudiante);
    void delete(Integer id);
}
