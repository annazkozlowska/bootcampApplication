package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
