package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "expertos")
public class Experto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "especializacion", nullable = false, length = 50)
    private String especializacion;
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_at")
    private LocalDateTime updatedAt;
}
