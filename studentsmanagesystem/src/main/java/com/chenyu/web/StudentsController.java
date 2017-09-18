package com.chenyu.web;

import com.chenyu.domain.Students;
import com.chenyu.exception.StudentsNotFoundException;
import com.chenyu.service.StudentsService;
import com.chenyu.service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;


    @GetMapping("/students")
    public String list(@PageableDefault(size = 5, sort ={"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                       Model model) {
        Page<Students> page1 = studentsService.findAllByPage(pageable);
        model.addAttribute("page", page1);
        return "students";
    }

    /**
     * 跳转到更新页面input
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/students/{id}/input")
    public String editPage(@PathVariable long id, Model model){
        Students students = studentsService.getStudentById(id);
        model.addAttribute("students", students);
        return "input";
    }

    /**
     * 跳转input提交页面
     * @return
     */
    @GetMapping("/students/input")
    public String inputPage(Model model){
        model.addAttribute("students", new Students());

        return "input";
    }

    /**
     * 提交一个学生信息
     * @param students
     * @return
     */
    @PostMapping("/students")
    public String post(Students students){
        studentsService.saveStudent(students);
        return "redirect:/students";

    }

    /**
     * 根据id删除学生成绩信息，利用ModelAndView进行重定向
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        this.studentsService.deleteStudentById(id);

        return new ModelAndView("redirect:/students");
    }

    /**
     * 根据id查询学生成绩详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/students/search")
    public String checkPage(@RequestParam("id") long id, Model model){
        Students students = studentsService.getStudentById(id);
        if( students == null) {
            throw new StudentsNotFoundException("学生信息未找到");
        }
            model.addAttribute("students", students);
        return "search";
    }
}

