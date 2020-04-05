package com.postman.slotbookingsystem.service;

import com.postman.slotbookingsystem.model.RequestSlot;

import java.time.LocalDate;
import java.util.List;

public interface SlotManager {
    boolean checkAvailabilityOfSlot(RequestSlot requestSlot);

    boolean bookSlot(RequestSlot requestSlot);

    boolean markSlotAvailability(RequestSlot requestSlot);

    void markAllSlotsAvailable(LocalDate date);

    List<RequestSlot> getAllAvailableSlotForDate(LocalDate date);

    List<RequestSlot> getAllBookedSlotForDate(LocalDate date);
}
