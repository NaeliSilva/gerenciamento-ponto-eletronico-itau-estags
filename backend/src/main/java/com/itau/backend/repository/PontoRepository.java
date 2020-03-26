package com.itau.backend.repository;

import com.itau.backend.models.Ponto;   
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontoRepository extends JpaRepository<Ponto, String> {

}