package com.ds6.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GradeDTO(
    UUID id,
    UUID studentId,
    UUID classId,
    String description,
    BigDecimal value,
    LocalDate date
) {}