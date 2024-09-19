package com.scv.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ResultadoCarreraPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "resultado_test_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_resultadosCarreras_resultadosTest"))
    private ResultadoTest resultadoTest;

    @ManyToOne
    @JoinColumn(name = "carrera", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_resultadosCarreras_carrera"))
    private Carrera carrera;

}
