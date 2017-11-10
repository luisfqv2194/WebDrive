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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author heltonsmith
 */
@Controller
public class MainController {
    
    public User usuario;
    
    
    //siempre los métodos deben retornar String
    @RequestMapping(method = RequestMethod.GET)
    public String otroMetodo(Model model) {
        return "index";
        
    }
   
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String recibir(@RequestParam("txtUsername") String username, 
            @RequestParam("txtPassword") String password, Model model){
        this.usuario = new User(username, password);
        if (username.trim().equals("") || password.trim().equals("")) {
            String a = "Los campos no pueden estar vacios!";
            model.addAttribute("err",a);
            return "index";
        }
        else if (this.usuario.validateUser()) {
            
            model.addAttribute("username",this.usuario.getUsername());
            return "homepage";
        }
        else {
            String a = "El usuario no existe";
            model.addAttribute("err",a);
            return "index";
        }
    }
    
    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String lala ( Model model) {
        model.addAttribute("var1",usuario.getUsername());
        model.addAttribute("username",usuario.getUsername());
        return "homepage";
    }
    
    
    
}
