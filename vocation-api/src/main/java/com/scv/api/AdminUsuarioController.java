package com.scv.api;


import com.scv.model.entity.Usuario;
import com.scv.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {
    private final AdminUsuarioService adminUsuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = adminUsuarioService.getAll();
        return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Usuario>> paginateUsuarios(
            @PageableDefault(size = 5, sort = "nombre")Pageable pageable) {
        Page<Usuario> usuarios = adminUsuarioService.paginate(pageable);
        return new ResponseEntity<Page<Usuario>>(usuarios,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Integer id) {
        Usuario usuarios = adminUsuarioService.findById(id);
        return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = adminUsuarioService.create(usuario);
        return new ResponseEntity<Usuario>(newUsuario,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id,
                                                 @RequestBody Usuario usuario) {
        Usuario updateUsuario = adminUsuarioService.update(id,usuario);
        return new ResponseEntity<Usuario>(updateUsuario,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Integer id){
        adminUsuarioService.delete(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }
}