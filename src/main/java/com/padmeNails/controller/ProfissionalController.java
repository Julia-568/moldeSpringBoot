package com.padmeNails.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padmeNails.entity.Profissional;
import com.padmeNails.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profissional> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Profissional buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Profissional salvar(@RequestBody Profissional profissional) {
        return service.salvar(profissional);
    }

    @PutMapping("/{id}")
    public Profissional atualizar(@PathVariable Long id,
                                  @RequestBody Profissional profissional) {
        return service.atualizar(id, profissional);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
