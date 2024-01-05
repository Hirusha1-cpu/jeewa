package lk.jeewacomputers.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import lk.jeewacomputers.employee.dao.DesignationDao;
import lk.jeewacomputers.employee.entity.Designation;

@RestController
public class DesignationController {
      @Autowired
    private DesignationDao dao;

     // create get mapping for get empllyee all data --- [/employee/findall]
    @GetMapping(value = "/designation/findall", produces = "application/json")
    public List<Designation> findAll() {
        // login user authentication and authorization
        return dao.findAll();
    }
}
