package com.ds6.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds6.dto.CreateGradeDTO;
import com.ds6.dto.GradeDTO;
import com.ds6.model.Grade;
import com.ds6.repository.GradeRepository;
import com.ds6.service.GradeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    @Transactional
    public GradeDTO createGrade(CreateGradeDTO dto) {
        Grade grade = new Grade();
        grade.setId(UUID.randomUUID());
        grade.setStudentId(dto.studentId());
        grade.setClassId(dto.classId());
        grade.setDescription(dto.description());
        grade.setValue(dto.value());
        grade.setDate(dto.date());

        Grade savedGrade = gradeRepository.save(grade);
        
        return toDTO(savedGrade);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GradeDTO> getGradesByStudent(UUID studentId) {
        return gradeRepository.findByStudentId(studentId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<GradeDTO> getGradesByClass(UUID classId) {
        return gradeRepository.findByClassId(classId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<GradeDTO> getGradesByStudentAndClass(UUID studentId, UUID classId) {
        return gradeRepository.findByStudentIdAndClassId(studentId, classId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private GradeDTO toDTO(Grade grade) {
        return new GradeDTO(
            grade.getId(),
            grade.getStudentId(),
            grade.getClassId(),
            grade.getDescription(),
            grade.getValue(),
            grade.getDate()
        );
    }
}
