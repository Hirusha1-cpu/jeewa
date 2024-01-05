package lk.jeewacomputers.employee.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import lk.jeewacomputers.employee.entity.EmployeeStatus;

public interface EmployeeStatusDao extends JpaRepository<EmployeeStatus, Integer> {
    
}
