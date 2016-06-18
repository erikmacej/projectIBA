package my.projekt.iba.servlets;

import javax.validation.Valid;
import my.projekt.iba.service.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
public class Servlet{
    
    @RequestMapping()
    public String viewForm(Model model){
        
        model.addAttribute("student", new Student());
        
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String viewResult(
        @Valid Student student,
        BindingResult result, Model model){
        
        if (result.hasErrors()){
            return "form";
	} else {
	    return "result";
        }       
      
    }
    
}
