package com.scv.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "resultados_Test")
public class ResultadoTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_resultadoTest_testVocacional"))
    private TestVocacional testVocacional;

    @OneToMany(mappedBy = "resultadoTest", cascade = CascadeType.ALL)
    private List<ResultadoCarrera> resultadoCarreras;
}
