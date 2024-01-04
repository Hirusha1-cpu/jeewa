package lk.jeewacomputers.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.jeewacomputers.user.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

    
} 
