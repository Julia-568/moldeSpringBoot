package com.padmeNails.service;

import com.padmeNails.entity.Endereco;
import com.padmeNails.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> listar() {
        return repository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("endereco nao encontrado"));
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco atualizar(Long id, Endereco endereco) {
        Endereco existente = buscarPorId(id);

        existente.setTipoLogradouro(endereco.getTipoLogradouro());
        existente.setDescricaoLogradouro(endereco.getDescricaoLogradouro());
        existente.setNumero(endereco.getNumero());
        existente.setBairro(endereco.getBairro());
        existente.setCep(endereco.getCep());
        existente.setCidade(endereco.getCidade());
        existente.setUf(endereco.getUf());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
