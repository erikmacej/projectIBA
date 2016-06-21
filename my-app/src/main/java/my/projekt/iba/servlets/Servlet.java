package my.projekt.iba.servlets;

import javax.validation.Valid;
import my.projekt.iba.service.Student;
import my.projekt.iba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
@Controller
public class Servlet{
    
    private StudentService studentService; 
    
    @Autowired(required=true)
    @Qualifier(value="studentService")
    public void setStudentService(StudentService studentService){
	this.studentService = studentService;
    }
    
    
    @RequestMapping(value={"", "list"})
    public String viewList(Model model){
 
        model.addAttribute("students", studentService.getAllStudents());
        
        return "list";
    }
    
    
    @RequestMapping("create")
    public String viewCreate(Model model){
        
        Student student = new Student();
        model.addAttribute("student", student);
        
        return "create";       
      
    }
    
    @RequestMapping(value ="create", method = RequestMethod.POST)
    public String submitCreate(
        @Valid Student student,
        BindingResult result, Model model){
        
        if(result.hasErrors()){
            return "create";
        }else{
            studentService.createStudent(student);
            return "redirect:list";
        }
    }
    
    @RequestMapping(value="delete", method= RequestMethod.POST)
    public String deleteStudent(@RequestParam("id") int id){
    
        studentService.deleteStudent(id);
        return "redirect:list";
        
    }
    
    @RequestMapping(value="detail", method= RequestMethod.POST)
    public String detailStudent(@RequestParam("id") int id,Model model){
    
        model.addAttribute("student",studentService.getStudent(id));
        return "detail";
        
    }
    
    @RequestMapping(value="update", method= RequestMethod.POST)
    public String updateStudent(@RequestParam("id") int id,Model model){
    
        model.addAttribute("student",studentService.getStudent(id));
        model.addAttribute("id", id);
        return "update";
        
    }
    
    @RequestMapping(value="updatesubmit", method= RequestMethod.POST)
    public String submitStudent(
        @RequestParam("id") int id,
        @Valid Student student,
        BindingResult result, Model model){
        
        if(result.hasErrors()){
            model.addAttribute("id", id);
            model.addAttribute("student", student);
            return "update";
        }else{
            studentService.updateStudent(id,student);
            return "redirect:list";
        }
        
    }
    
}
