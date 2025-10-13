package com.ds6.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds6.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, UUID> {
    List<Grade> findByStudentId(UUID studentId);
    List<Grade> findByClassId(UUID classId);
    List<Grade> findByStudentIdAndClassId(UUID studentId, UUID classId);
}