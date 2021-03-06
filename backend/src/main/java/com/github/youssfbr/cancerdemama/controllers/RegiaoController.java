package com.github.youssfbr.cancerdemama.controllers;

import com.github.youssfbr.cancerdemama.entities.Regiao;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.interfaces.IRegiaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regioes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegiaoController {

    private final IRegiaoService regiaoService;

    @GetMapping
    public ResponseEntity<List<Regiao>> findAll() {
        return ResponseEntity.ok(regiaoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(regiaoService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRegiao(@RequestBody Regiao regiao) {
        regiaoService.createRegiao(regiao);
    }

    @PutMapping("{id}")
    public void updateRegiao(@PathVariable long id, @RequestBody Regiao regiao) throws EntityNotFoundException {
        regiaoService.updateRegiao(id, regiao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        regiaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
