package pl.sda20.bootcamp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda20.bootcamp.model.User;
import pl.sda20.bootcamp.service.RoleService;
import pl.sda20.bootcamp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminController{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/formularz-admin")
    public String createAdmin(Model model){
        User admin = User.builder().build();
        model.addAttribute("admin", admin);

        return "admin/formularz-admin";
    }
    @PostMapping("/add-admin")
    public String addAdmin (@Valid @ModelAttribute("admin") User admin,
                            BindingResult bindingResult,
                            Model model) {
        model.addAttribute("admin", admin);

        if (bindingResult.hasErrors()) {
            return "admin/formularz-admin";
        }

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));

        admin.setRole(roleService.getRole("admin"));
        userService.save(admin);
        return "admin/add-admin";
    }
    @RequestMapping(value ="/lista-admini", method = RequestMethod.GET)
    public String getAllAdmins(Model model){

        model.addAttribute("allAdmins", userService.getAllAdmins());


        return "admin/lista-adminow";
    }

    @GetMapping(value ="/usun-admina")
    public String deleteAdmin(@RequestParam Long id, Model model){

        userService.delete(id);

        model.addAttribute("allAdmins", userService.getAllAdmins());
        model.addAttribute("deletedAdmin", true);

        return "admin/lista-adminow";
    }

    @GetMapping(value ="/edytuj-admina")
    public String editAdmin(@RequestParam Long id, Model model){


        model.addAttribute("admin", userService.getUser(id));


        return "admin/formularz-admin-edytowany";
    }

}
