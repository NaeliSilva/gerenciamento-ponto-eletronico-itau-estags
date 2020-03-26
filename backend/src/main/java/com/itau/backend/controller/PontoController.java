package com.itau.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.itau.backend.models.Ponto;   
import com.itau.backend.repository.PontoRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PontoController {

    @Autowired
    PontoRepository pontoRepository;

    @PostMapping("/ponto")
    public Ponto salvaPonto(@RequestBody @Valid Ponto data) {
        return pontoRepository.save(data);
    }
}