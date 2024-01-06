package lk.jeewacomputers.privilege.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PrivilegeController {

    @RequestMapping(value = "/privilege")
    public ModelAndView privilegeUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("system_User_Components/privilege.html");
        viewEmp.addObject("title","Privilege Management : BIT Project 2024");
        viewEmp.addObject("classPrivi", "active");
        return viewEmp;
    }
    
}
