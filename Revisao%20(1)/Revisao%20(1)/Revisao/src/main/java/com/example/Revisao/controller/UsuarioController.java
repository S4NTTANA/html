package com.example.Revisao.controller;


import com.example.Revisao.modal.Usuario;
import com.example.Revisao.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@CrossOrigin (origins = "*") // Aceita conexão de solicitação externas.

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List <Usuario> ListarTodos(){
        return usuarioService.Listartodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody Usuario usuario){
        usuarioService.Salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem","Usuario cadastrado com sucesso"));
    }
}
