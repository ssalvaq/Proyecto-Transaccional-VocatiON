package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "planesPremium")
public class PlanPremium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private float precio;
    @Column(name = "duracion", nullable = false)
    private int duracion;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_at")
    private LocalDateTime updatedAt;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_planPremium_usuario"))
    private Usuario usuario;
}
