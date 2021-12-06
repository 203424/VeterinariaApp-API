package com.cesarsanchezbackend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesarsanchezbackend.app.entitiy.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
