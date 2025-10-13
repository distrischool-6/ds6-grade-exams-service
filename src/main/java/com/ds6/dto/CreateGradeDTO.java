package com.ds6.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGradeDTO(
    @NotNull(message = "Student ID cannot be null")
    UUID studentId,

    @NotNull(message = "Class ID cannot be null")
    UUID classId,

    @NotBlank(message = "Description cannot be blank")
    String description,

    @NotNull(message = "Value cannot be null")
    @DecimalMin(value = "0.0", message = "Grade value must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Grade value must be at most 10.0")
    BigDecimal value,

    @NotNull(message = "Date cannot be null")
    LocalDate date
) {}
