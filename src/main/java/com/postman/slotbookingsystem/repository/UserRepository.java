package com.postman.slotbookingsystem.repository;

import com.postman.slotbookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
