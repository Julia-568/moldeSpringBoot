package com.padmeNails.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.padmeNails.entity.Usuario;
import com.padmeNails.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario) {

        String senhaCriptografada =
                passwordEncoder.encode(usuario.getSenhaUsuario());

        usuario.setSenhaUsuario(senhaCriptografada);

        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario usuarioExistente = buscarPorId(id);

        usuarioExistente.setLoginUsuario(usuario.getLoginUsuario());

        if (usuario.getSenhaUsuario() != null
                && !usuario.getSenhaUsuario().isBlank()) {

            String senhaCriptografada =
                    passwordEncoder.encode(usuario.getSenhaUsuario());

            usuarioExistente.setSenhaUsuario(senhaCriptografada);
        }

        return repository.save(usuarioExistente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }

    public boolean validarSenha(String senhaDigitada, String senhaBanco) {
        return passwordEncoder.matches(senhaDigitada, senhaBanco);
    }
    
    public Usuario autenticar(String login, String senha) {
        Usuario usuario = repository.findByLoginUsuario(login)
                .orElseThrow(() ->
                    new RuntimeException("Usuário ou senha incorretos"));

        if (!validarSenha(senha, usuario.getSenhaUsuario())) {
            throw new RuntimeException("Usuário ou senha incorretos");
        }

        return usuario;
    }
}