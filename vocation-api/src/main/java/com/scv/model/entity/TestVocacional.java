package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "testVocacionales")
public class TestVocacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_at")
    private LocalDateTime updatedAt;
    @Column(name = "estudiante_id", nullable = false)
    private int estudianteId;

    @ManyToOne
    @JoinColumn(name = "estudiante", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_testVocacional_estudiante"))
    private Estudiante estudiante;
}
