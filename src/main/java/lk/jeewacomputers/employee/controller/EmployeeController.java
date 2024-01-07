package lk.jeewacomputers.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

import java.util.List;

import lk.jeewacomputers.employee.dao.EmployeeDao;
import lk.jeewacomputers.employee.dao.EmployeeStatusDao;
import lk.jeewacomputers.employee.entity.Employee;



@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeDao dao;


 //create employeestatusdao object
    @Autowired
    private EmployeeStatusDao empStatusDao;

    
    @RequestMapping(value = "/employee")
    public ModelAndView employeeUI() {
        ModelAndView viewEmp = new ModelAndView();
        viewEmp.setViewName("system_User_Components/employee.html");
        viewEmp.addObject("title","Employee Management : BIT Project 2024");
        viewEmp.addObject("classEmp", "active");
        return viewEmp;
    }

    // create get mapping for get empllyee all data --- [/employee/findall]
    @GetMapping(value = "/employee/findall", produces = "application/json")
    public List<Employee> findAll() {
        // login user authentication and authorization
        return dao.findAll(Sort.by(Direction.DESC, "id"));
    }
      // create post mapping for save employee
    @PostMapping(value = "/employee")
    public String save(@RequestBody Employee employee) {

        try {

            //check unique value 
            //mobile no
            Employee extEmployeeMobileNo = dao.getEmployeeByMobile(employee.getMobile());
            if (extEmployeeMobileNo != null) {
                return "Save not completed :Inserted Mobile is Already Existing";
            }
            //check nic no
            Employee extEmployeeNIC = dao.getEmployeeByNIC(employee.getNic());
            if (extEmployeeNIC != null) {
                return "Save not completed :Inserted NIC is Already Existing";
            }

            employee.setAddeddatetime(LocalDateTime.now().toLocalDate());//set current date time
            String nextEmpNo = dao.getNextEmpNo();
            if (nextEmpNo.equals("") || nextEmpNo.equals(null)) {
                employee.setEmpno("00000001");
                
            } else {
                employee.setEmpno(nextEmpNo); //emp no auto generated
            }
            // designation.setName("Software Engineer");
            // dao.save(designation);
            employee.setDeletestatus(false);
            dao.save(employee);
            // return "OK";
            return nextEmpNo;
        } catch (Exception e) {

            return "save Not Completed" + e.getMessage();
        }

    }

    @DeleteMapping(value = "/employee")
    public String delete(@RequestBody Employee employee){
   

      
        try {
            Employee extemp = dao.getReferenceById(employee.getId());
            if (extemp == null) {
                return "Delete not completed :employee not exist" ;
            }
            //hard delete
            //dao.delete(employee);
            //dao.delete(dao.gerReferenceById(employee.getId()));

            extemp.setEmployeestatus_id(empStatusDao.getReferenceById(3));
            extemp.setDeletedatetime(LocalDateTime.now().toLocalDate());
            extemp.setDeletestatus(true);
            dao.save(extemp);
      
            return "OK";
        } catch (Exception e) {
        
            return "Delete Not Completed" + e.getMessage();
        }
    }

    @PutMapping(value = "/employee")
    public String update(@RequestBody Employee employee){
        //need to check duplicate record
        Employee extEmployee = dao.getReferenceById(employee.getId());
        if(extEmployee == null){
            return "Update Not Completed : Employee not available..!";
        }
        Employee extEmployeeMobile = dao.getEmployeeByMobile(employee.getMobile());
        if (extEmployeeMobile != null && extEmployeeMobile.getId() != employee.getId()) {
            return "Update not completed : Mobile no already existing..!";
        }
        Employee extEmployeeNic = dao.getEmployeeByNIC(employee.getNic());
        if(extEmployeeNic != null && extEmployeeNic.getId() != employee.getId()){
            return "Update not completed : NIC no already existing..!";
        }

        try {
            employee.setLastmodifydatetime(LocalDateTime.now().toLocalDate());
           
            dao.save(employee);
            //check employee status and change user status
  

            return "OK";
        } catch (Exception e) {
        
            return "Update not completed" + e.getMessage();
        }
        
    }


}
