/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

//import bean.Auto;
import WebDriveLogic.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author heltonsmith
 */
@Controller
@RequestMapping("/login.htm")
public class LogInController {
    
    //siempre los métodos deben retornar String
    @RequestMapping(method = RequestMethod.GET)
    public String otroMetodo(Model model) {
        return "index";
        
    }
   
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView recibir(@RequestParam("txtUsername") String username, 
            @RequestParam("txtPassword") String password, Model model){
        User usuario = new User(username, password);
        if (username.trim().equals("") || password.trim().equals("")) {
            String a = "Los campos no pueden estar vacios!";
            model.addAttribute("err",a);
            return new ModelAndView("index");
        }
        else if (usuario.validateUser()) {
            model.addAttribute("username",usuario.getUsername());
            return new ModelAndView("homepage");
        }
        else {
            String a = "El usuario no existe";
            model.addAttribute("err",a);
            return new ModelAndView("index");
        }
    }
    
}
