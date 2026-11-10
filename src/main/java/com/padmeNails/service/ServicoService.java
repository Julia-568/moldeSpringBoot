package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Servico;
import com.padmeNails.repository.ServicoRepository;

@Service
public class ServicoService {
	
	private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> listar() {
        return repository.findAll();
    }

    public Servico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("servico nao encontrado"));
    }

    public Servico salvar(Servico servico) {
        return repository.save(servico);
    }

    public Servico atualizar(Long id, Servico servico) {
        Servico existente = buscarPorId(id);

        existente.setTipoServico(servico.getTipoServico());
        existente.setValorServico(servico.getValorServico());
        existente.setDuracaoServico(servico.getDuracaoServico());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}

