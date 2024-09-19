package com.scv.service.impl;

import com.scv.model.entity.Usuario;
import com.scv.repository.UsuarioRepository;
import com.scv.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario registerUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El correo ya esta registrado");
        }

        //Establecer fechas de creacion
        usuario.setCreatedAt(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario loginUsuario(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isEmpty() || !usuarioOpt.get().getContraseña().equals(password)) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return usuarioOpt.get();
    }


}
