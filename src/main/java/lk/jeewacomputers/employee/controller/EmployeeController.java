package lk.jeewacomputers.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import lk.jeewacomputers.employee.dao.EmployeeDao;
import lk.jeewacomputers.employee.entity.Employee;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeDao dao;
    
    @RequestMapping(value = "/employee")
    public ModelAndView employeeUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("admin/employee.html");
        viewEmp.addObject("title","Employee Management : BIT Project 2024");
        return viewEmp;
    }

    // create get mapping for get empllyee all data --- [/employee/findall]
    @GetMapping(value = "/employee/findall", produces = "application/json")
    public List<Employee> findAll() {
        // login user authentication and authorization
        return dao.findAll(Sort.by(Direction.DESC, "id"));
    }

}
