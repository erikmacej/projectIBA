package my.projekt.iba.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * @author Erik Macej
 */
public class StudentServiceListImpl implements StudentService {
   
    private List<Student> students;
    Student student;
  
    public StudentServiceListImpl(){
        this.students = new ArrayList<>();
    }

    @Override
    public void createStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(int id,Student student) {
        
        Student s = getStudent(id);        
        s.setName(student.getName());
        s.setSurname(student.getSurname());
        s.setSex(student.getSex());
        s.setBornDate(student.getBornDate());

    }

    @Override
    public void deleteStudent(int id) {
        students.remove(getStudent(id));
    }

    @Override
    public Student getStudent(int id) {
        for(Student s : students){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }
    

}
