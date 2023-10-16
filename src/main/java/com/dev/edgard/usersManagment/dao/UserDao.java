package com.dev.edgard.usersManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.edgard.usersManagment.models.User;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long>{   
    
}
