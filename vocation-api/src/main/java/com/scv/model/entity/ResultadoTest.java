package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resultadosTest")
public class ResultadoTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "test_id", nullable = false)
    private int testId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_resultadoTest_testVocacional"))
    private TestVocacional testVocacional;
}
