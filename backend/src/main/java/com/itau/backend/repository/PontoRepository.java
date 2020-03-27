package com.itau.backend.repository;

import com.itau.backend.models.Ponto;   
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PontoRepository extends JpaRepository<Ponto, String> {
    List<Ponto> findByUsuarioId(long usuarioId);
}