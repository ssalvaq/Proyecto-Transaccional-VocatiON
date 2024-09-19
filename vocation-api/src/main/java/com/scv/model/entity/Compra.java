package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "total", nullable = false)
    private float total;
    @Column(name = "paymentstatus", nullable = false)
    private String paymentstatus;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_compra_usuario"))
    private Usuario usuario;
}
