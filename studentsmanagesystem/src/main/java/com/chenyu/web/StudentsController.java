package com.chenyu.web;

import com.chenyu.domain.Students;
import com.chenyu.exception.StudentsNotFoundException;
import com.chenyu.service.StudentsService;
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
        Students students = studentsService.findOne(id);
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
        studentsService.save(students);
        return "redirect:/students";

    }

    //删除学生成绩
    //利用ModelAndView进行重定向
    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        this.studentsService.delete(id);

        return new ModelAndView("redirect:/students");
    }

    @GetMapping("/students/search")
    public String checkPage(@RequestParam("id") long id, Model model){
        Students students = studentsService.findOne(id);
        if( students == null) {
            throw new StudentsNotFoundException("学生信息未找到");
        }
            model.addAttribute("students", students);
        return "search";
    }
}

