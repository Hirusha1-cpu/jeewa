package lk.jeewacomputers.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import lk.jeewacomputers.employee.entity.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    
    //define query for getnext employee number
    @Query(value = "SELECT lpad(max(e.empno)+1,8,0) as empno FROM jeewacomputersproject.employee as e;", nativeQuery = true)
    public String getNextEmpNo();

    //define query for employee by give mobile number
    @Query(value = "SELECT e FROM Employee e WHERE e.mobile = ?1")
    //?is params
    public Employee getEmployeeByMobile(String mobile);

    //define query for employee by given nic
    //2nd param example
    @Query(value = "SELECT e FROM Employee e WHERE e.nic =:nic")
    public Employee getEmployeeByNIC(@Param("nic") String nic);

  

    
}
