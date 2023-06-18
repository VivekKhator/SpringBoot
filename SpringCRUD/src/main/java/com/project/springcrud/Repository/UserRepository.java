package com.project.springcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.springcrud.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
