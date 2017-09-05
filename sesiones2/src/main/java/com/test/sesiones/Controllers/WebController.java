package com.test.sesiones.Controllers;

import com.test.sesiones.Entities.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@SessionAttributes("personas")
public class WebController {

    @RequestMapping(value = {"","/","/test"}, method = RequestMethod.GET)
    public String test(Model model){
      
    	model.addAttribute("persona",new Persona());
        if(!model.containsAttribute("personas")){
            model.addAttribute("personas", new ArrayList<Persona>());
            
        };
    //    modelAndView.setViewName("test");
        return "test";
    }

    @RequestMapping(value="/agregarPersona", method = RequestMethod.POST)
    public String agregarPersona(Model model, Persona persona,
                                       @ModelAttribute("personas") ArrayList<Persona> personas){
        personas.add(persona);
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personas);
   
        return "test";

    }
}
