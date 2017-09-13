package com.chenyu.service;

import com.chenyu.Repository.StudentsRepository;
import com.chenyu.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;
    //显示数据
    /**
     * 查询所有的
     * @return
     */
    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    /**
     * 提交一个
     * @param
     */
    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    /**
     * 获取一条
     * @param id
     * @return
     */
    public Students findOne(long id){
        return studentsRepository.findOne(id);
    }

    public List<Students> findById(long id) {
        return studentsRepository.findById(id);
    }

    /**
     * 删除一条
     * @param
     */
    public void delete(long id) {
        studentsRepository.delete(id);
    }

    public List<Students> findByName(String name) {
        return studentsRepository.findByName(name);
    }

    public Page<Students> findAllByPage(Pageable pageable) {
        return studentsRepository.findAll(pageable);
    }



}


