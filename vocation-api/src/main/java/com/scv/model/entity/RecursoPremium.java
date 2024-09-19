package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "recursos_Premium")
@IdClass(RecursoPremiumPK.class)
public class RecursoPremium {

    @Id
    private Integer recursoEducativo;
    @Id
    private Integer planPremium;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;

}
