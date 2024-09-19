package com.scv.api;

import com.scv.model.entity.Estudiante;
import com.scv.service.AdminEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/estudiantes")
public class AdminEstudianteController {
    private final AdminEstudianteService adminEstudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        List<Estudiante> estudiantes = adminEstudianteService.getAll();
        return new ResponseEntity<List<Estudiante>>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Estudiante>> paginateEstudiantes(
            @PageableDefault(size = 5, sort = "nivelAcademico") Pageable pageable) {
        Page<Estudiante> estudiantes = adminEstudianteService.paginate(pageable);
        return new ResponseEntity<Page<Estudiante>>(estudiantes,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getUsuarioById(@PathVariable("id") Integer id) {
        Estudiante estudiante = adminEstudianteService.findById(id);
        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estudiante> createUsuario(@RequestBody Estudiante estudiante) {
        Estudiante newEstudiante = adminEstudianteService.create(estudiante);
        return new ResponseEntity<Estudiante>(newEstudiante,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateUsuario(@PathVariable("id") Integer id,
                                                 @RequestBody Estudiante estudiante) {
        Estudiante updateEstudiante = adminEstudianteService.update(id,estudiante);
        return new ResponseEntity<Estudiante>(updateEstudiante,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> deleteUsuario(@PathVariable("id") Integer id){
        adminEstudianteService.delete(id);
        return new ResponseEntity<Estudiante>(HttpStatus.NO_CONTENT);
    }
}
