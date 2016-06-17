package my.projekt.iba.servlets;

import java.time.LocalDate;
import my.projekt.iba.service.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
@Controller
public class Servlet{
    
    @RequestMapping("form")
    public String viewForm(Model model){
         
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String viewResult(
        @RequestParam(value = "input1") String input1,
        @RequestParam(value = "input2") String input2,
        @RequestParam(value = "input3") String input3,
        @RequestParam(value = "input4") String input4,
        Model model){
        
        Student student = new Student();
        
        student.setMeno(input1);
        student.setPriezvisko(input2);
        student.setDatumNarozeni(LocalDate.parse(input3));
        student.setPohlavi(input4);
        
        model.addAttribute("student", student);
        
        return "result";
        
    }
    
}
