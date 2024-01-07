package lk.jeewacomputers.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lk.jeewacomputers.user.dao.UserDao;
import lk.jeewacomputers.user.entity.UserEntity;


@RestController
public class UserController {

    @Autowired
    private UserDao dao;

     @RequestMapping(value = "/user")
     public ModelAndView userUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("system_User_Components/user.html");
        viewEmp.addObject("title","User Management : BIT Project 2024");
        viewEmp.addObject("classUser", "active");
        return viewEmp;
    }

      // create get mapping for get user all data --- [/user/findall]
    @GetMapping(value = "/user/findall", produces = "application/json")
    public List<UserEntity> findAll() {
      
        return dao.findAll();
    }
    
}
