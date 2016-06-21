package my.projekt.iba.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Erik Macej,433 744
 */
@Service
public class StudentServiceDbImpl implements StudentService {
    
    private StudentServiceDao studentServiceDao; 
    
    public void setStudentServiceDao(StudentServiceDao studentServiceDao){
        this.studentServiceDao = studentServiceDao;
    } 
    
    @Override
    @Transactional
    public void createStudent(Student student) {
        this.studentServiceDao.createStudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(int id, Student student) {
        this.studentServiceDao.updateStudent(id, student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        this.studentServiceDao.deleteStudent(id);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return this.studentServiceDao.getStudent(id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return this.studentServiceDao.getAllStudents();
    }
    
}
