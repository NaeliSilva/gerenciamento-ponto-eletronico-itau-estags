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
    PontoRepository pontoRepository;

    @GetMapping(value="/")
    public String getMethodName() {
        return "Olá Mundo VSCode!";
    }
    
    @GetMapping("/usuario")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario dadosUsuario(@PathVariable(value = "id") long id){
        return usuarioRepository.findById(id);
    }

    @GetMapping("/usuario/busca/{nome}")
    public Usuario dadosUsuarioByNome(@PathVariable(value = "nome") String nome){
        return usuarioRepository.findByNome(nome);
    }

    @PostMapping("/usuario")
    public Usuario salvaUsuario(@RequestBody @Valid Usuario data) {
        return usuarioRepository.save(data);
    }

    @PutMapping("/usuario")
    public Usuario atualizaUsuario(@RequestBody @Valid Usuario data) {
        return usuarioRepository.save(data);
    }
}