package pl.sda20.bootcamp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.JstlUtils;
import pl.sda20.bootcamp.model.Trainer;
import pl.sda20.bootcamp.repository.TrainerRepository;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;


    public void save(Trainer trainer){
        trainerRepository.save(trainer);
    }


    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }


    public void delete(Long id) {
        trainerRepository.deleteById(id);
    }

    public Trainer getTrainer(Long id) {
       return trainerRepository.getOne(id);
    }
}
