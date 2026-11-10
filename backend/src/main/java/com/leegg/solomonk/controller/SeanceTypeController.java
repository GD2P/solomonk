package com.leegg.solomonk.controller;

import com.leegg.solomonk.dto.ExercicePrevuDto;
import com.leegg.solomonk.dto.SeanceTypeDto;
import com.leegg.solomonk.service.SeanceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seance-types")
public class SeanceTypeController {
    private final SeanceTypeService seanceTypeService;

    public SeanceTypeController(SeanceTypeService seanceTypeService) {
        this.seanceTypeService = seanceTypeService;
    }

    @GetMapping
    public List<SeanceTypeDto> getSeanceType(){
        return seanceTypeService.findAll();
    }
    @GetMapping("/{id}/exercices-prevus")
    public List<ExercicePrevuDto> getExercicesPrevus(@PathVariable Long id) {
        return seanceTypeService.findExercicesPrevus(id);
    }
}
