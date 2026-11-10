package com.padmeNails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padmeNails.entity.Cliente;
import com.padmeNails.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("cliente nao encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Cliente existente = buscarPorId(id);

        existente.setUsuario(cliente.getUsuario());
        existente.setEndereco(cliente.getEndereco());
        existente.setNomeCliente(cliente.getNomeCliente());
        existente.setSobrenomeCliente(cliente.getSobrenomeCliente());
        existente.setTelefoneCliente(cliente.getTelefoneCliente());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
