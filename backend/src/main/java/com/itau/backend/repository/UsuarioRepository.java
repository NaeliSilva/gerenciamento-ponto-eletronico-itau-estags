package com.itau.backend.repository;

import com.itau.backend.models.Usuario;   
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}