package com.leegg.solomonk.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ExercicePrevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int ordre;
    @Column(nullable = false)
    private int seriesCible;
    @Column(nullable = false)
    private int repsCible;
    @Column(nullable = false)
    private BigDecimal chargeCible;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;
    @ManyToOne(optional = false)
    @JoinColumn(name = "seanceType_id")
    private SeanceType seanceType;

    public ExercicePrevu(){}

    public Long getId() {
        return id;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public int getSeriesCible() {
        return seriesCible;
    }

    public void setSeriesCible(int seriesCible) {
        this.seriesCible = seriesCible;
    }

    public int getRepsCible() {
        return repsCible;
    }

    public void setRepsCible(int repsCible) {
        this.repsCible = repsCible;
    }

    public BigDecimal getChargeCible() {
        return chargeCible;
    }

    public void setChargeCible(BigDecimal chargeCible) {
        this.chargeCible = chargeCible;
    }

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    public SeanceType getSeanceType() {
        return seanceType;
    }

    public void setSeanceType(SeanceType seanceType) {
        this.seanceType = seanceType;
    }
}
