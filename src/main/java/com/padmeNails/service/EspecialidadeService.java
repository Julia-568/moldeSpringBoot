package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Especialidade;
import com.padmeNails.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	
	private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    public List<Especialidade> listar() {
        return repository.findAll();
    }

    public Especialidade buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("especialidade nao encontrada"));
    }

    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    public Especialidade atualizar(Long id, Especialidade especialidade) {
        Especialidade existente = buscarPorId(id);

        existente.setTipoEspecialidade(especialidade.getTipoEspecialidade());
        existente.setDescricaoEspecialidade(especialidade.getDescricaoEspecialidade());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
