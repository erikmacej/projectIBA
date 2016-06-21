package my.projekt.iba.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;



/**
 * @author Erik Macej
 */
@Repository
public class StudentServiceDbImplDao implements StudentServiceDao {
   
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory){
	this.sessionFactory = sessionFactory;
    }
  
    @Override
    public void createStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void updateStudent(int id,Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        Student s = (Student) session.get(Student.class,new Integer(id));
        s.setName(student.getName());
        s.setSurname(student.getSurname());
        s.setBornDate(student.getBornDate());
        s.setSex(student.getSex());
        session.update(s);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class,new Integer(id)));
    }

    @Override
    public Student getStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.get(Student.class,new Integer(id));
        return student; 
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student").list();
        return studentList;
    }
    

}
