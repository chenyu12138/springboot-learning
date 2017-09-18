package com.chenyu.web;

import com.chenyu.domain.Students;
import com.chenyu.service.StudentsService;
import com.chenyu.service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StudentApi {

    @Autowired
    private StudentsService studentsService;


    //插入数据
    @PostMapping(value = "/students")
    public Students studentsAdd(Students students){


        return studentsService.saveStudent(students);

    }
    //查询
    @GetMapping(value="/students/{id}")
    public Students studentsFindOne(@PathVariable("id") long id){

        return studentsService.getStudentById(id);

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

        return studentsService.saveStudent(students);

    }
    //删除
    @DeleteMapping(value="/students/{id}")
    public void studentsDelete(@PathVariable("id") Long id){
        studentsService.deleteStudentById(id);

    }

    //分页
    @GetMapping("/students")
    public Page<Students> getAll(@PageableDefault(size = 5, sort ={"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return studentsService.findAllByPage(pageable);
    }
}
