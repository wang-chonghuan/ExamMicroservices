package com.wang.exammsv.domain;

import com.wang.exammsv.domain.Blankpaper;
import com.wang.exammsv.domain.StudentExamResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentExamResultRepository extends CrudRepository<StudentExamResult, Long> {
    List<StudentExamResult> findByExamId(long examId);

    List<StudentExamResult> findByStudentIdAndExamId(@Param("student_id")long studentId, @Param("exam_id")long examId);
}
