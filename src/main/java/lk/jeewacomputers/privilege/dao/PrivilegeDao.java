package lk.jeewacomputers.privilege.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.jeewacomputers.privilege.entity.PrivilegeEntity;

public interface PrivilegeDao extends JpaRepository<PrivilegeEntity, Integer> {

}