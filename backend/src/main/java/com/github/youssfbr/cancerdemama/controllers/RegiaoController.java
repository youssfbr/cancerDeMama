package com.github.youssfbr.cancerdemama.controllers;

import com.github.youssfbr.cancerdemama.entities.Regiao;
import com.github.youssfbr.cancerdemama.services.RegiaoService;
import com.github.youssfbr.cancerdemama.services.exceptions.RegiaoNotFoundException;
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

    private final RegiaoService regiaoService;

    @GetMapping
    public ResponseEntity<List<Regiao>> findAll() {
        return ResponseEntity.ok(regiaoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id) throws RegiaoNotFoundException {
        return ResponseEntity.ok(regiaoService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Regiao regiao) {
        regiaoService.createRegiao(regiao);
    }

    @PutMapping("{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Regiao regiao) throws RegiaoNotFoundException {
        regiaoService.updateRegiao(id, regiao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws RegiaoNotFoundException {
        regiaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
