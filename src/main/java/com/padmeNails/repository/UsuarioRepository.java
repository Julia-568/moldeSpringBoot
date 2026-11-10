package com.padmeNails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.padmeNails.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByLoginUsuario(String loginUsuario);

}
