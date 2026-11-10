package com.leegg.solomonk.controller;

import com.leegg.solomonk.dto.CreerSeanceRequestDto;
import com.leegg.solomonk.dto.SeanceDto;
import com.leegg.solomonk.entity.Seance;
import com.leegg.solomonk.service.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seances")
public class SeanceController {

    private SeanceService seanceService;

    public SeanceController(SeanceService seanceService){
        this.seanceService = seanceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeanceDto createSeance(@RequestBody CreerSeanceRequestDto request) {
        return seanceService.creer(request);
    }

    @GetMapping
    public List<SeanceDto> getSeances() {
        return seanceService.findAll();
    }
}
