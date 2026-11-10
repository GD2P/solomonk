package com.leegg.solomonk.dto;

import java.math.BigDecimal;

public record SerieRequestDto(Long exerciceId, int numero, int reps, BigDecimal charge) {}
