package pl.sda20.bootcamp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import pl.sda20.bootcamp.model.Trainer;
import pl.sda20.bootcamp.model.User;
import pl.sda20.bootcamp.service.RoleService;
//import pl.sda20.bootcamp.service.TrainerService;
import pl.sda20.bootcamp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/trener")
public class TrainerController {

//    @Autowired
//    private TrainerService trainerService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/formularz-trener")
    public String createTrainer(Model model){

        User trainer = User.builder().build();

        model.addAttribute("trainer", trainer);

        return "trainer/formularz-trener";
    }

    @PostMapping(value = "/add-trainer")
    public String addTrainer(@Valid @ModelAttribute("trainer") User trainer, BindingResult bindingResult, Model model){
        model.addAttribute("trainer", trainer);

        if (bindingResult.hasErrors()) {
            if (bindingResult.getErrorCount() == 1 &&
                    bindingResult.hasFieldErrors("password")) {
                User user = userService.getUser(trainer.getId());
                trainer.setPassword(user.getPassword());
            } else {
                return "trainer/formularz-trener";
            }
        }

        /** Kodowanie hasła studenta w bazie danych */
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        trainer.setPassword(bCryptPasswordEncoder.encode(trainer.getPassword()));

        trainer.setRole(roleService.getRole("trener"));
        userService.save(trainer);
        return "trainer/add-trainer";
    }

    @RequestMapping(value ="/lista-trenerzy", method = RequestMethod.GET)
    public String getAllTrainers(Model model){

        model.addAttribute("allTrainers", userService.getAllTrainers());


        return "trainer/lista-trenerow";
    }

    @GetMapping(value ="/usun-trenera")
    public String deleteTrainer(@RequestParam Long id, Model model){

        userService.delete(id);

        model.addAttribute("allTrainers", userService.getAllTrainers());
        model.addAttribute("deletedTrainer", true);

        return "trainer/lista-trenerow";
    }

    @GetMapping(value ="/edytuj-trenera")
    public String editTrainer(@RequestParam Long id, Model model){


        model.addAttribute("trainer", userService.getUser(id));


        return "trainer/formularz-trener-edytowany";
    }


}


