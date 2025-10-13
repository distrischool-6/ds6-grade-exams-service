package com.ds6.service;

import com.ds6.dto.CreateGradeDTO;
import com.ds6.dto.GradeDTO;

import java.util.List;
import java.util.UUID;

public interface GradeService {
    public GradeDTO createGrade(CreateGradeDTO createGradeDTO);
    public List<GradeDTO> getGradesByStudent(UUID studentId);
    public List<GradeDTO> getGradesByClass(UUID classId);
    public List<GradeDTO> getGradesByStudentAndClass(UUID studentId, UUID classId);
}