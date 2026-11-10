
package com.padmeNails.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padmeNails.entity.Usuario;
import com.padmeNails.service.UsuarioService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest dados) {
        try {
            Usuario usuario = service.autenticar(
                dados.loginUsuario(),
                dados.senhaUsuario()
            );

            return ResponseEntity.ok(Map.of(
                "mensagem", "Login realizado com sucesso!",
                "idUsuario", usuario.getIdUsuario(),
                "loginUsuario", usuario.getLoginUsuario()
            ));

        } catch (RuntimeException erro) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                        "mensagem", "Usuário ou senha incorretos."
                    ));
        }
    }

    public record LoginRequest(
        String loginUsuario,
        String senhaUsuario
    ) {}
}
