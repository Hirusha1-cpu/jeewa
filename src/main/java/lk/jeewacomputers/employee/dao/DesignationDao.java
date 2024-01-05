package lk.jeewacomputers.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.jeewacomputers.employee.entity.Designation;

public interface DesignationDao extends JpaRepository<Designation, Integer> {
    
}
