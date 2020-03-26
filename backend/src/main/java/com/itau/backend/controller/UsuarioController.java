package com.itau.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.itau.backend.models.Usuario;   
import com.itau.backend.repository.*; 
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/usuario")
    public Usuario salvaGestor(@RequestBody @Valid Usuario data) {
        return usuarioRepository.save(data);
    }
}