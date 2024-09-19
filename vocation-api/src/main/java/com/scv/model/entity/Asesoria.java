package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "asesorias")
@IdClass(AsesoriaPK.class)
public class Asesoria {

    @Id
    private Integer experto;
    @Id
    private Integer usuario;

    @Column(name = "duracion", nullable = false)
    private float duracion;

}
