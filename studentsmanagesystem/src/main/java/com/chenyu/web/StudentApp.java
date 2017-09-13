package com.chenyu.web;

import com.chenyu.Repository.StudentsRepository;
import com.chenyu.domain.Students;
import com.chenyu.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentApp {

    @Autowired
    private StudentsService studentsService;


    //插入数据
    @PostMapping(value = "/students")
    public Students studentsadd(Students students){


        return studentsService.save(students);

    }
    //查询
    @GetMapping(value="/students/{id}")
    public Students studentsfindOne(@PathVariable("id") long id){

        return studentsService.findOne(id);

    }
    //更新
    @PutMapping(value="/students/{id}")
    public Students studentsUpdate(@RequestParam long id,
                                   @RequestParam String sex,
                                   @RequestParam String name,
								   @RequestParam String chinese,
                                           @RequestParam String math,
                                           @RequestParam String english){
        Students students = new Students();
        students.setId(id);
        students.setSex(sex);
        students.setName(name);
        students.setChinese(chinese);
        students.setMath(math);
        students.setEnglish(english);

        return studentsService.save(students);

    }
    //删除
    @DeleteMapping(value="/students/{id}")
    public void studentsDelete(@PathVariable("id") Long id){
        studentsService.delete(id);

    }

    @GetMapping("/students")
    public Page<Students> getAll(@PageableDefault(size = 5, sort ={"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return studentsService.findAllByPage(pageable);
    }
}
