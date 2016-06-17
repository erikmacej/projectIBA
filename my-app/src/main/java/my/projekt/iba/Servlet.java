package my.projekt.iba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
@Controller
public class Servlet{
    
    @RequestMapping("hello/{x}")
    public String getX(@PathVariable String x,Model model){
	       
        try{
            int param = Integer.parseInt(x);
            model.addAttribute("x", param);
        }catch(NumberFormatException ex){
            model.addAttribute("x", 1);
        }    
            
        return "hello";
	
    }
    
    @RequestMapping("hello")
    public String pathWithoutParameter(Model model){
        
        model.addAttribute("x",1);
        
        return "hello";
    }
    
}
