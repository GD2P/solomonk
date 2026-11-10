package com.leegg.solomonk.repository;

import com.leegg.solomonk.entity.ExercicePrevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicePrevuRepository extends JpaRepository<ExercicePrevu,Long> {
    List<ExercicePrevu> findBySeanceTypeIdOrderByOrdre(Long seanceTypeId);
}
