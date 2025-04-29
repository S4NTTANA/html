package com.example.Revisao.service;


import com.example.Revisao.modal.Usuario;
import com.example.Revisao.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService{
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List <Usuario> Listartodos (){
        return usuarioRepository.findAll();
    }
    public Usuario Salvar (@Valid Usuario usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Esse email ja foi cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }


}
