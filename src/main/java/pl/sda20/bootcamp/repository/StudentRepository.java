package pl.sda20.bootcamp.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import pl.sda20.bootcamp.model.User;
////import pl.sda20.bootcamp.model.Student;
//
//import java.util.List;
//
//@Repository
//public interface StudentRepository extends JpaRepository<Student, Long> {
//
////    List<Student> getByCourseName(String courseName);
////    List<Student> getFirstByCourseName(String courseName);
////    List<Student> getFirst10ByCourseName(String courseName);
////    List<Student> getFirst10ByCourseNameAndMode(String courseName, String mode);
//
//
//    //metodki potrzebne do wyszukiwania studenta
//    List<Student> getByFirstName(String firstName);
//    List<Student> getByLastName(String lastName);
//    List<Student> getByEmail(String email);
//    List<Student> getByPhone(String phone);
//    List<Student> getByCourseName(String courseName);
//    List<Student> getByMode(String mode);
//
//    //adnotacja Query - prezentacja 98
////1 sposob
//    @Query("SELECT s FROM Student s WHERE s.courseName = ?1 and s.mode = ?2")  // 1 i 2 to pozycja naszego parametru w metodzie
//    List<Student> findByCourseNameAndMode(String courseName, String mode);
//
////// 2 sposob
////@Query("SELECT s FROM Student s WHERE s.courseName = :courseName and s.mode = :mode")
////List<Student> findByCourseNameAndMode(@Param ("couseName")String courseName,
////                                      @Param ("mode") String mode);
//
//
////           WRÓCIMY DO TEGO
////    @Query(value = "SELECT * FROM Student WHERE isnull(:courseName, 1) = courseName" +
////            " and isnull(:mode, 1) = mode",nativeQuery = true)
////    List<Student> searchStudents(@Param ("courseName")String courseName,
////                                @Param ("mode") String mode);
//
//}
