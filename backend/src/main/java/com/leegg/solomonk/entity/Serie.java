package com.leegg.solomonk.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int reps;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal charge;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;
    @ManyToOne(optional = false)
    @JoinColumn(name = "seance_id")
    private Seance seance;

    public Serie(){}

    public long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
