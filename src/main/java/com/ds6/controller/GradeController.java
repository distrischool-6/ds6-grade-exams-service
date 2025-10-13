package com.ds6.controller;

import com.ds6.dto.CreateGradeDTO;
import com.ds6.dto.GradeDTO;
import com.ds6.service.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeDTO> createGrade(@Valid @RequestBody CreateGradeDTO createGradeDTO) {
        GradeDTO createdGrade = gradeService.createGrade(createGradeDTO);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getGrades(
            @RequestParam(required = false) UUID studentId,
            @RequestParam(required = false) UUID classId) {

        if (studentId != null && classId != null) {
            return ResponseEntity.ok(gradeService.getGradesByStudentAndClass(studentId, classId));
        }

        if (studentId != null) {
            return ResponseEntity.ok(gradeService.getGradesByStudent(studentId));
        }

        if (classId != null) {
            return ResponseEntity.ok(gradeService.getGradesByClass(classId));
        }

        return ResponseEntity.ok(Collections.emptyList());
    }
}
