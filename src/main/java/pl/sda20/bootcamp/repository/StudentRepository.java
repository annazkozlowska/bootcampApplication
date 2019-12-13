package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> getByCourseName(String courseName);
    List<Student> getFirstByCourseName(String courseName);
    List<Student> getFirst10ByCourseName(String courseName);
    List<Student> getFirst10ByCourseNameAndMode(String courseName, String mode);


}
