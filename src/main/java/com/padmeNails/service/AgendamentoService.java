package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Agendamento;
import com.padmeNails.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("agendamento nao encontrado"));
    }

    public Agendamento salvar(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento agendamento) {
        Agendamento existente = buscarPorId(id);

        existente.setCliente(agendamento.getCliente());
        existente.setServico(agendamento.getServico());
        existente.setProfissional(agendamento.getProfissional());
        existente.setDataServico(agendamento.getDataServico());
        existente.setHorarioServico(agendamento.getHorarioServico());
        existente.setStatusAgendamento(agendamento.getStatusAgendamento());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}