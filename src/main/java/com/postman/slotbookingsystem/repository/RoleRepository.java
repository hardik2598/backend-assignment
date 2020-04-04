package com.postman.slotbookingsystem.repository;

import com.postman.slotbookingsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
