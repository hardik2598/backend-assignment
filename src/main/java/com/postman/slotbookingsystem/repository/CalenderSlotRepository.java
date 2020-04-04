package com.postman.slotbookingsystem.repository;

import com.postman.slotbookingsystem.model.CalenderSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderSlotRepository extends JpaRepository<CalenderSlot, Long> {
}
