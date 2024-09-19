package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "planes_Premium")
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
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_planPremium_usuario"))
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_planPremium_compra"))
    public Compra compra;

    @OneToMany(mappedBy = "planPremium", cascade = CascadeType.ALL)
    private List<RecursoPremium> recursoPremium;
}
