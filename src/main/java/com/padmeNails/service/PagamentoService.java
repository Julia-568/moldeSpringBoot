package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Pagamento;
import com.padmeNails.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listar() {
        return repository.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("pagamento nao encontrado"));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public Pagamento atualizar(Long id, Pagamento pagamento) {
        Pagamento existente = buscarPorId(id);

        existente.setAgendamento(pagamento.getAgendamento());
        existente.setFormaPagamento(pagamento.getFormaPagamento());
        existente.setValorPagamento(pagamento.getValorPagamento());
        existente.setDataPagamento(pagamento.getDataPagamento());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
