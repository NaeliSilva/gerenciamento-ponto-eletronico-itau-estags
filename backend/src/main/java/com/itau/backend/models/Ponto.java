package com.itau.backend.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ponto_eletronico")
public class Ponto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(name = "usuario_id")
    private long usuarioId;
    @CreationTimestamp
    private LocalDateTime data;
    @NotNull
    @Column(name = "tipo_entrada")
    private String tipo;

    public Ponto() {
    }

    public Ponto(long id, @NotNull long usuarioId, LocalDateTime data, @NotNull String tipo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.data = data;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = data; }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}