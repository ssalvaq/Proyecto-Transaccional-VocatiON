package com.scv.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class RecursoPremiumPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "recurso_educativo_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_recursoPremium_recursoEducativo"))
    private RecursoEducativo recursoEducativo;

    @ManyToOne
    @JoinColumn(name = "plan_premium_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_recursoPremium_planPremium"))
    private PlanPremium planPremium;
}
