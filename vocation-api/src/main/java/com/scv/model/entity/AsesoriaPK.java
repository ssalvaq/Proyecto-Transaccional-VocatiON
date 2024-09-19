package com.scv.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class AsesoriaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "experto_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_asesoria_experto"))
    private Experto experto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_asesoria_usuario"))
    private Usuario usuario;
}
