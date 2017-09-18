package com.chenyu.service;

import java.util.List;
import com.chenyu.domain.Students;

/**
 * Author chenyu
 * 2017/9/18 14:54
 */
public interface StudentsService {
    List<Students> findAllStudents();

    Students getStudentById(long id);

    Students saveStudent(Students students);

    void deleteStudentById(long id);


}
