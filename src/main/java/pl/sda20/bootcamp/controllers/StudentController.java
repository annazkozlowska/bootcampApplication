package pl.sda20.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
//import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.model.User;
import pl.sda20.bootcamp.service.RoleService;
//import pl.sda20.bootcamp.service.StudentService;
import pl.sda20.bootcamp.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

//    @Autowired
//    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping(value = "/formularz-student")
    public String form(Model model) {

        User student = User.builder().build();

        model.addAttribute("student", student);

        return "student/formularz-student";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(@Valid @ModelAttribute("student") User student, BindingResult bindingResult, Model model) {

        model.addAttribute("student", student);

                if (bindingResult.hasErrors()) {
                    if (bindingResult.getErrorCount() == 1 &&
                            bindingResult.hasFieldErrors("password")) {
                        User user = userService.getUser(student.getId());
                        student.setPassword(user.getPassword());
                    } else {
                return "student/formularz-student";
            }
        }

        /** Kodowanie hasła studenta w bazie danych */
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));

        student.setRole(roleService.getRole("student"));
        userService.save(student);
        return "student/add-student";
    }

    //BindingResult bindingResult -  przechowujemy w nim bledy

    @GetMapping(value = "/usun-studenta")
    public String deleteStudent(@RequestParam Long id, Model model) {

        userService.delete(id);

        model.addAttribute("allStudents", userService.getAllStudents());
        model.addAttribute("deletedStudent", true);

        return "student/lista-studentow";
    }

    @RequestMapping(value = "/lista-studentow", method = RequestMethod.GET)
    public String getAllStudents(Model model) {

        model.addAttribute("allStudents", userService.getAllStudents());

        return "student/lista-studentow";

    }

    @GetMapping(value = "/edytuj-studenta")
    public String editStudent(@RequestParam Long id, Model model) {


        model.addAttribute("student", userService.getUser(id));


        return "student/formularz-student-edytowany";
    }

    //metoda ktora pomaga szukac studenta po konkretnej frazie
    // do parametrow dodajemy searchPhrase i columnName (tak jak nazwalismy w html)
    @PostMapping(value = "/szukaj")
    public String getStudents(@RequestParam String searchPhrase,
                              @RequestParam String columnName,
                              Model model) {

        model.addAttribute("allStudents", userService.getStudents(searchPhrase, columnName));

        return "student/lista-studentow";
    }

    //redirect - jak szukamy studenta po konkretnym parametrze i ODSWIEZYMY strone
    // to powroci nam do znowu do listy pierwotnej
    // czary
    @GetMapping(value = "/szukaj")
    public String getStudents() {
        return "redirect:lista-studentow";

    }


    /** do usunięcia, ponieważ nie ma już pola courseName */
    // w chromie można to potem sprawdzić wpisująć:
    // http://localhost:8080/wyszukiwanie-kurs?courseName=Frontend&mode=dzienny
//    @GetMapping(value = "/wyszukiwanie-kurs")
//    public String getStudentsByCourse(@RequestParam String courseName,
//                                      @RequestParam String mode,
//                                      Model model){
//        model.addAttribute("allStudents", studentService.findByCourseNameAndMode(courseName, mode));
//        return "student/lista-studentow";
//    }




//    @GetMapping("lista-studentow/szukaj")
////    public String searchStudents(@RequestParam String courseName,
////                                      @RequestParam String mode,
////                                      Model model){
////        model.addAttribute("allStudents", studentService.searchStudents(courseName, mode));
////        return "student/lista-studentow";
////    }
}
