package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resultadosCarrera")
public class ResultadoCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultadoTestId, carreraId;
    @Column(name = "puntuacion", nullable = false)
    private float puntuacion;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "resultadoTestId", referencedColumnName = "id"
    ,foreignKey = @ForeignKey(name = "FK_resultadosCarreras_resultadosTest"))
    private ResultadoTest resultadoTest;

    @ManyToOne
    @JoinColumn(name = "carrera", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_resultadosCarreras_carrera"))
    private Carrera carrera;

}

