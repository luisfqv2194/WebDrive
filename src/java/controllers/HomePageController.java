/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author XPC
 */
@Controller
public class HomePageController {
    
    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    public String lala (String username, Model model) {
        model.addAttribute("var1",username);
        return "homepage";
    }
}
