package com.leegg.solomonk.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "seanceType_id")
    private SeanceType seanceType;

    public Seance(){}

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SeanceType getSeanceType() {
        return seanceType;
    }

    public void setSeanceType(SeanceType seanceType) {
        this.seanceType = seanceType;
    }
}
