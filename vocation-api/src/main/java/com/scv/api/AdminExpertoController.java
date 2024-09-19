package com.scv.api;

import com.scv.model.entity.Experto;
import com.scv.service.AdminExpertoService;
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
@RequestMapping("/admin/expertos")
public class AdminExpertoController {
    private final AdminExpertoService adminExpertoService;

    @GetMapping
    public ResponseEntity<List<Experto>> getAllExperto() {
        List<Experto> expertos = adminExpertoService.getAll();
        return new ResponseEntity<List<Experto>>(expertos, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Experto>> paginateExperto(
            @PageableDefault(size = 5, sort = "especializacion") Pageable pageable) {
        Page<Experto> expertos = adminExpertoService.paginate(pageable);
        return new ResponseEntity<Page<Experto>>(expertos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experto> getExpertoById(@PathVariable("id") Integer id) {
        Experto expertos = adminExpertoService.findById(id);
        return new ResponseEntity<Experto>(expertos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Experto> createExperto(@RequestBody Experto usuario) {
        Experto newExperto = adminExpertoService.create(usuario);
        return new ResponseEntity<Experto>(newExperto,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experto> updateExperto(@PathVariable("id") Integer id,
                                                 @RequestBody Experto expertos) {
        Experto updateUsuario = adminExpertoService.update(id,expertos);
        return new ResponseEntity<Experto>(updateUsuario,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Experto> deleteExperto(@PathVariable("id") Integer id){
        adminExpertoService.delete(id);
        return new ResponseEntity<Experto>(HttpStatus.NO_CONTENT);
    }
}
