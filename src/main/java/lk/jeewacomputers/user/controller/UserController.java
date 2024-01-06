package lk.jeewacomputers.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

     @RequestMapping(value = "/user")
     public ModelAndView userUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("system_User_Components/user.html");
        viewEmp.addObject("title","User Management : BIT Project 2024");
        viewEmp.addObject("classUser", "active");
        return viewEmp;
    }
    
}
