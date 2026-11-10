package com.leegg.solomonk.repository;

import com.leegg.solomonk.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie,Long> {
    List<Serie> findBySeanceIdOrderByNumero(Long seanceId);
}
