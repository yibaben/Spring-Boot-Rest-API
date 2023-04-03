package com.yibaben.SpringBootRestAPI.repository;

import com.yibaben.SpringBootRestAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
