package com.itau.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.itau.backend.models.Usuario;   
import com.itau.backend.repository.*; 
import org.springframework.beans.factory.annotation.Autowired;


/**
 * HelloController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value="/")
    public String getMethodName() {
        return "Olá Mundo VSCode!";
    }
    
    @GetMapping("/usuario")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }
}