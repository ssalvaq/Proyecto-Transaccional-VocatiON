package com.scv.service;

import com.scv.model.entity.Usuario;

public interface UsuarioService {
    Usuario registerUsuario(Usuario usuario);
    Usuario loginUsuario(String email, String contraseña);
    void deleteUsuario(Integer id);
    void resetPassword(Integer id, String newPassword);
}
