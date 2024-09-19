package com.scv.service.impl;

import com.scv.model.entity.Usuario;
import com.scv.repository.UsuarioRepository;
import com.scv.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUsuarioServiceImpl implements AdminUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Usuario> paginate(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Usuario create(Usuario usuario) {
        usuario.setCreatedAt(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario update(Integer id, Usuario updateUsuario) {
        Usuario usuarioFromDb = findById(id);
        usuarioFromDb.setNombre(updateUsuario.getNombre());
        usuarioFromDb.setContraseña(updateUsuario.getContraseña());
        usuarioFromDb.setEmail(updateUsuario.getEmail());
        usuarioFromDb.setTelefono(updateUsuario.getTelefono());
        usuarioFromDb.setDireccion(updateUsuario.getDireccion());
        usuarioFromDb.setTipo(updateUsuario.getTipo());
        usuarioFromDb.setRoles(updateUsuario.getRoles());
        usuarioFromDb.setUpdatedAt(LocalDateTime.now());
        return usuarioRepository.save(usuarioFromDb);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found "));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }
}
