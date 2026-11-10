package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Profissional;
import com.padmeNails.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public List<Profissional> listar() {
        return repository.findAll();
    }

    public Profissional buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("profissional nao encontrada"));
    }

    public Profissional salvar(Profissional profissional) {
        return repository.save(profissional);
    }

    public Profissional atualizar(Long id, Profissional profissional) {
        Profissional existente = buscarPorId(id);

        existente.setNomeProfissional(profissional.getNomeProfissional());
        existente.setSobrenomeProfissional(profissional.getSobrenomeProfissional());
        existente.setTelefoneProfissional(profissional.getTelefoneProfissional());
        existente.setEspecialidade(profissional.getEspecialidade());
        existente.setComissaoProfissional(profissional.getComissaoProfissional());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
