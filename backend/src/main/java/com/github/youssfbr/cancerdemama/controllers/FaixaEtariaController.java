package com.github.youssfbr.cancerdemama.controllers;

import com.github.youssfbr.cancerdemama.entities.FaixaEtaria;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.interfaces.IFaixaEtariaService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faixa_etarias")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FaixaEtariaController {

    private final IFaixaEtariaService faixaEtariaService;

    @GetMapping
    public ResponseEntity<List<FaixaEtaria>> findAll() {
        return ResponseEntity.ok(faixaEtariaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<FaixaEtaria> findById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(faixaEtariaService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria) {
        faixaEtariaService.createFaixaEtaria(faixaEtaria);
    }

    @PutMapping("{id}")
    public void updateFaixaEtaria(@PathVariable long id, @RequestBody FaixaEtaria faixaEtaria) throws EntityNotFoundException {
        faixaEtariaService.updateFaixaEtaria(id, faixaEtaria);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        faixaEtariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
