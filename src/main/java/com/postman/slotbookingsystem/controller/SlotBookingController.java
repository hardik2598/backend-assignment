package com.postman.slotbookingsystem.controller;

import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.model.User;
import com.postman.slotbookingsystem.service.SlotManagerImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.postman.slotbookingsystem.model.User;

@RestController
@RequestMapping("/logged-in")
public class SlotBookingController {

    private User activeUser;

    @PostMapping("/book-slot")
    public String bookSlot(@RequestBody RequestSlot requestSlot) {
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(activeUser);
        if (slotManagerInstance.bookSlot(requestSlot)) {
            return "Successfully book slot on date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Cannot book slot on date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @PostMapping("/check-slot-availability")
    public String checkSlotAvailability(@RequestBody RequestSlot requestSlot) {
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(activeUser);
        if (slotManagerInstance.checkAvailabilityOfSlot(requestSlot)) {
            return "Slot available for date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Slot not available for date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @PostMapping("/mark-slot-available")
    public String markSlotAvailable(@RequestBody RequestSlot requestSlot) {
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(activeUser);
        if (slotManagerInstance.markSlotAvailability(requestSlot)) {
            return "Slot marked available for date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Slot cannot be marked as available for date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @PostMapping("/mark-slot-available")
    public String markAllSlotAvailable(@RequestBody RequestSlot requestSlot) {
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(activeUser);
        slotManagerInstance.markAllSlotsAvailable(requestSlot.getSlotDate());
        return "All slots marked as available for date: " + requestSlot.getSlotDate();
    }

    @GetMapping("/get-all-available-slots")
    public List<RequestSlot> getAllAvailableSlots(@RequestBody RequestSlot requestSlot) {
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(activeUser);
        return slotManagerInstance.getAllAvailableSlotForDate(requestSlot.getSlotDate());
    }
}
