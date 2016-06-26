package my.projekt.iba.servlets;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import my.projekt.iba.service.Student;
import my.projekt.iba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author Erik Macej,433 744
 */


@Controller
@RequestMapping("/rest")
public class StudentServiceRest {
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value ="/create",method = RequestMethod.PUT)
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student,
        BindingResult result){
        
        if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for(Object object : result.getAllErrors()){
                if(object instanceof FieldError) {
                    errors.add(messageSource.getMessage((FieldError) object, null));
                }
            }
            return new ResponseEntity(errors.toString(),HttpStatus.BAD_REQUEST);
        }
        studentService.createStudent(student);
        return new ResponseEntity(student.toString() + " úspešne vytvorený",HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        
        Student student = studentService.getStudent(id);
                
        if(student == null){
            return new ResponseEntity("Študent sa nenašiel",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(student,HttpStatus.OK);
        }
    }
    
    @RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudent(@Valid @RequestBody Student student,BindingResult result, 
            @PathVariable("id") int id){
        
         if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for(Object object : result.getAllErrors()){
                if(object instanceof FieldError) {
                    errors.add(messageSource.getMessage((FieldError) object, null));
                }
            }
            return new ResponseEntity(errors.toString(),HttpStatus.BAD_REQUEST);
        }
        
        Student s = studentService.getStudent(id);
        
        if(s == null){
            return new ResponseEntity("Študent sa nenašiel",HttpStatus.NOT_FOUND);
        }else{
            studentService.updateStudent(id, student);
            return new ResponseEntity("Študent bo zmenený",HttpStatus.OK);
        }
    
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        
        Student s = studentService.getStudent(id);
        
        if(s == null){
            return new ResponseEntity("Študent sa nenašiel",HttpStatus.NOT_FOUND);
        }else{
            studentService.deleteStudent(id);
            return new ResponseEntity("Študent bol vymazaný",HttpStatus.OK);
        }
    
    }
    
    @RequestMapping(value="/getall",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents(){
        
        List<Student> students = studentService.getAllStudents();
        
        return new ResponseEntity(students,HttpStatus.OK);
    
    }
}
