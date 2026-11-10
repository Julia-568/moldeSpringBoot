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

import com.padmeNails.entity.FormaPagamento;
import com.padmeNails.service.FormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
@CrossOrigin(origins = "*")
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    public FormaPagamentoController(FormaPagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<FormaPagamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FormaPagamento buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public FormaPagamento salvar(@RequestBody FormaPagamento formaPagamento) {
        return service.salvar(formaPagamento);
    }

    @PutMapping("/{id}")
    public FormaPagamento atualizar(@PathVariable Long id,
                                    @RequestBody FormaPagamento formaPagamento) {
        return service.atualizar(id, formaPagamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}