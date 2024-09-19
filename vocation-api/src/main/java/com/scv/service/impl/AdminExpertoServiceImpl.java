package com.scv.service.impl;

import com.scv.model.entity.Experto;
import com.scv.repository.ExpertoRepository;
import com.scv.service.AdminExpertoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminExpertoServiceImpl implements AdminExpertoService {
    private final ExpertoRepository expertoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Experto> getAll() {
        return expertoRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Page<Experto> paginate(Pageable pageable) {
        return expertoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Experto findById(Integer id) {
        return expertoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experto not found "));
    }

    @Transactional
    @Override
    public Experto create(Experto experto) {
        experto.setCreatedAt(LocalDateTime.now());
        return expertoRepository.save(experto);
    }

    @Transactional
    @Override
    public Experto update(Integer id, Experto updateExperto) {
        Experto expertoFromDb = findById(id);
        expertoFromDb.setEspecializacion(updateExperto.getEspecializacion());
        expertoFromDb.setBio(updateExperto.getBio());
        expertoFromDb.setUpdatedAt(LocalDateTime.now());
        return expertoRepository.save(expertoFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Experto experto = findById(id);
        expertoRepository.delete(experto);
    }
}
