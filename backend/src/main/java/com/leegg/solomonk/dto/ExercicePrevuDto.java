package com.leegg.solomonk.dto;

import java.math.BigDecimal;

public record ExercicePrevuDto(Long exerciceId, String exerciceNom, int ordre, int seriesCible, int repsCible, BigDecimal chargeCible) { }
