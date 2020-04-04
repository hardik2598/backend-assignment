package com.postman.slotbookingsystem.repository;

import com.postman.slotbookingsystem.model.CalenderSlot;
import com.postman.slotbookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CalenderSlotRepository extends JpaRepository<CalenderSlot, Long> {

}
