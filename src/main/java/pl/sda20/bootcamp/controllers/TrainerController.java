package pl.sda20.bootcamp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.sda20.bootcamp.model.Trainer;
import pl.sda20.bootcamp.service.TrainerService;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping(value = "/formularz-trener")
    public String createTrainer(Model model){

        Trainer trainer = Trainer.builder().build();

        model.addAttribute("trainer", trainer);

        return "trainer/formularz-trener";
    }

    @PostMapping(value = "/add-trainer")
    public String addTrainer(Trainer trainer, Model model){

        trainerService.save(trainer);

        model.addAttribute("trainer", trainer);

        return "trainer/add-trainer";
    }

    @RequestMapping(value ="/lista-trenerzy", method = RequestMethod.GET)
    public String getAllTrainers(Model model){

        model.addAttribute("allTrainers", trainerService.getAllTrainers());


        return "trainer/lista-trenerow";
    }

    @GetMapping(value ="/usun-trenera")
    public String deleteTrainer(@RequestParam Long id, Model model){

        trainerService.delete(id);

        model.addAttribute("allTrainers", trainerService.getAllTrainers());

        return "trainer/lista-trenerow";
    }

    @GetMapping(value ="/edytuj-trenera")
    public String editTrainer(@RequestParam Long id, Model model){


        model.addAttribute("trainer", trainerService.getTrainer(id));


        return "trainer/formularz-trener-edytowany";
    }


}


