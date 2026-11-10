package com.leegg.solomonk.dto;

import java.time.LocalDate;
import java.util.List;

public record SeanceDto(Long id, LocalDate date, String seanceTypeNom, List<SerieDto> series) {}
