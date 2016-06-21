package my.projekt.iba.service;

import java.util.List;

/**
 * @author Erik Macej,433 744
 */
public interface StudentService {
    
    void createStudent(Student student);
    void updateStudent(int id,Student student);
    void deleteStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
    
}
