package com.scv.service;

import com.scv.model.entity.Experto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminExpertoService {
    List<Experto> getAll();
    Page<Experto> paginate(Pageable pageable);
    Experto findById(Integer id);
    Experto create(Experto experto);
    Experto update(Integer id, Experto updateExperto);
    void delete(Integer id);
}
