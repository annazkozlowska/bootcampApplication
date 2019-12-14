package pl.sda20.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/formularz-student")
    public String form(Model model){

        Student student = Student.builder().build();

        model.addAttribute("student", student);

        return "student/formularz-student";
    }
    @PostMapping(value ="/add-student")
    public String addStudent(Student student, Model model){

        studentService.save(student);

        model.addAttribute("student", student);

        return "student/add-student";
    }

    @GetMapping(value ="/usun-studenta")
    public String deleteStudent(@RequestParam Long id, Model model){

        studentService.delete(id);

        model.addAttribute("allStudents", studentService.getAllStudents());

        return "student/lista-studentow";
    }

    @RequestMapping(value ="/lista-studentow", method = RequestMethod.GET)
    public  String getAllStudents(Model model){

        model.addAttribute("allStudents", studentService.getAllStudents());

        return "student/lista-studentow";

    }
    @GetMapping(value ="/edytuj-studenta")
    public String editStudent(@RequestParam Long id, Model model){


        model.addAttribute("student", studentService.getStudent(id));


        return "student/formularz-student-edytowany";
    }


}
