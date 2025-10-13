package com.ds6.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
public class Grade {

    @Id
    private UUID id;

    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "class_id", nullable = false)
    private UUID classId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal value;

    @Column(nullable = false)
    private LocalDate date;
}
