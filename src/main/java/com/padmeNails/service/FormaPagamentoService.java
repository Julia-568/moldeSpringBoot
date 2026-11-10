package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.FormaPagamento;
import com.padmeNails.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	private final FormaPagamentoRepository repository;

    public FormaPagamentoService(FormaPagamentoRepository repository) {
        this.repository = repository;
    }

    public List<FormaPagamento> listar() {
        return repository.findAll();
    }

    public FormaPagamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("forma de pagamento nao encontrada"));
    }

    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return repository.save(formaPagamento);
    }

    public FormaPagamento atualizar(Long id, FormaPagamento formaPagamento) {
        FormaPagamento existente = buscarPorId(id);

        existente.setTipoFormaPagamento(formaPagamento.getTipoFormaPagamento());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
