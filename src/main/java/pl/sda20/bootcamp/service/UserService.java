package pl.sda20.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.model.User;
import pl.sda20.bootcamp.repository.RoleRepository;
//import pl.sda20.bootcamp.repository.StudentRepository;
import pl.sda20.bootcamp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    // Dzieki temu jak zostanie stworzony obiekt StudentService to zostanie automatycznie przypisany obietkt
    private UserRepository userRepository;  //tworzymy obiekt

    @Autowired
    private RoleRepository roleRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> getAllStudents() {
        return userRepository.getByRole(roleRepository.getByRole("student"));
    }
    public List<User> getAllTrainers() {
        return userRepository.getByRole(roleRepository.getByRole("trener"));
    }
    public List<User> getAllAdmins() {
        return userRepository.getByRole(roleRepository.getByRole("admin"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(Long id){
        return userRepository.getOne(id);
    }


    //poniżej metoda do wyszukiwania po parametrze
    // jako parametry searchPhrase i columnName
    public List<User> getStudents(String searchPhrase, String columnName ){

        switch (columnName){
            case "firstName":
                return userRepository.getByFirstName(searchPhrase);

            case "lastName":
                return userRepository.getByLastName(searchPhrase);

            case "email":
                return userRepository.getByMail(searchPhrase);

            case "phone":
                return userRepository.getByPhone(searchPhrase);

            case "mode":
                return userRepository.getByMode(searchPhrase);

        }
        return null;
    }

//    public List<Student> findByCourseNameAndMode(String courseName, String mode){
//        return  studentRepository.findByCourseNameAndMode(courseName, mode);
//    }


//    public List<Student> searchStudents(String courseName, String mode){
//        return  studentRepository.searchStudents(courseName, mode);
//    }


}


