package com.leegg.solomonk.dto;

import java.time.LocalDate;
import java.util.List;

public record CreerSeanceRequestDto(Long seanceTypeId, LocalDate date, List<SerieRequestDto> series) {}
