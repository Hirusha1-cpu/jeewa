package lk.jeewacomputers.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

     @RequestMapping(value = "/user")
    public ModelAndView userUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("admin/user.html");
        return viewEmp;
    }
    
}
