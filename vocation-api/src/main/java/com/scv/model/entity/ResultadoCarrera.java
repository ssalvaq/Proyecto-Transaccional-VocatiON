package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resultados_Carrera")
@IdClass(ResultadoCarreraPK.class)
public class ResultadoCarrera {

    @Id
    private Integer resultadoTest;
    @Id
    private Integer carrera;

    @Column(name = "puntuacion", nullable = false)
    private float puntuacion;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}

