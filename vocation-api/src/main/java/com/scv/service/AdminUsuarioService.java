package com.scv.service;

import com.scv.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminUsuarioService {
    List<Usuario> getAll();
    Page<Usuario> paginate(Pageable pageable);
    Usuario findById(Integer id);
    Usuario create(Usuario usuario);
    Usuario update(Integer id, Usuario updateUsuario);
    void delete(Integer id);
}
