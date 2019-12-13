package pl.sda20.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired // Dzieki temu jak zostanie stworzony obiekt StudentService to zostanie automatycznie przypisany obietkt
    private StudentRepository studentRepository;  //tworzymy obiekt


    public void save(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void delete(Long id) {
         studentRepository.deleteById(id);
    }

    public Student getStudent(Long id){
        return studentRepository.getOne(id);
    }


}
