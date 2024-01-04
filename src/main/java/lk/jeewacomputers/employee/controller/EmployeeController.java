package lk.jeewacomputers.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {
    
    @RequestMapping(value = "/employee")
    public ModelAndView employeeUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("admin/employee.html");
        return viewEmp;
    }
}
