package com.chenyu.service;

import com.chenyu.Repository.StudentsRepository;
import com.chenyu.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;
    //显示数据

    /**
     * 查询所有的信息
     * @return
     */
    @Override
    public List<Students> findAllStudents() {

        return studentsRepository.findAll();
    }

    /**
     * 新增一个学生成绩信息
     * @param
     */
    @Override
    public Students saveStudent(Students students) {

        return studentsRepository.save(students);
    }

    /**
     * 获取一条
     * @param id
     * @return
     */
    @Override
    public Students getStudentById(long id) {

        return studentsRepository.findOne(id);
    }

    /**
     * 删除一条
     * @param
     */
    @Override
    public void deleteStudentById(long id) {

        studentsRepository.delete(id);
    }

    /**
     * 进行分页
     * @param pageable
     * @return
     */
    public Page<Students> findAllByPage(Pageable pageable) {

        return studentsRepository.findAll(pageable);
    }

    @Override
    public List<Students> getStudentsByName(String name) {
        return studentsRepository.findByName(name);
    }
}


















