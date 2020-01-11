package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Role;
import pl.sda20.bootcamp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getByFirstName(String firstName);

    List<User> getByLastName(String lastName);

    List<User> getByMail(String mail);

    List<User> getByPhone(String phone);

    List<User> getByMode(String mode);

    List<User> getByRole(Role role);
}
//wszystkie metody te co byly w student repository, tylko usuwamy kilka niepotrzebnych
// m.in. nie mamy juz pola courseName wiec tamtych nie dajemy
