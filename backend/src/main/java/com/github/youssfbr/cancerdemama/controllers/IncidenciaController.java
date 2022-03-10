package com.github.youssfbr.cancerdemama.controllers;

import com.github.youssfbr.cancerdemama.entities.Incidencia;
import com.github.youssfbr.cancerdemama.entities.Regiao;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.interfaces.IIncidenciaService;
import com.github.youssfbr.cancerdemama.services.interfaces.IRegiaoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incidencias")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IncidenciaController {

    private final IIncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<List<Incidencia>> findAll() {
        return ResponseEntity.ok(incidenciaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Incidencia> findById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(incidenciaService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createIncidencia(@RequestBody Incidencia incidencia) {
        incidenciaService.createIncidencia(incidencia);
    }

    @PutMapping("{id}")
    public void updateIncidencia(@PathVariable long id, @RequestBody Incidencia incidencia) throws EntityNotFoundException {
        incidenciaService.updateIncidencia(id, incidencia);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        incidenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
