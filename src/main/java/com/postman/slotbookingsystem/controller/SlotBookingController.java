package com.postman.slotbookingsystem.controller;

import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.service.InterControllerMap;
import com.postman.slotbookingsystem.service.SlotManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logged-in")
public class SlotBookingController {

    @RequestMapping("/book-slot")
    public String bookSlot() {
        RequestSlot requestSlot = (RequestSlot) InterControllerMap.getUrl2ObjectMapping().get(InterControllerMap.getUrl2UrlMapping().get("/logged-in/book-slot"));
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(InterControllerMap.getActiveUser());
        if (slotManagerInstance.bookSlot(requestSlot)) {
            return "Successfully book slot on date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Cannot book slot on date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @RequestMapping("/check-slot-availability")
    public String checkSlotAvailability() {
        RequestSlot requestSlot = (RequestSlot) InterControllerMap.getUrl2ObjectMapping().get(InterControllerMap.getUrl2UrlMapping().get("/logged-in/check-slot-availability"));
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(InterControllerMap.getActiveUser());
        if (slotManagerInstance.checkAvailabilityOfSlot(requestSlot)) {
            return "Slot available for date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Slot not available for date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @RequestMapping("/mark-slot-available")
    public String markSlotAvailable() {
        RequestSlot requestSlot = (RequestSlot) InterControllerMap.getUrl2ObjectMapping().get(InterControllerMap.getUrl2UrlMapping().get("/logged-in/mark-slot-available"));
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(InterControllerMap.getActiveUser());
        if (slotManagerInstance.markSlotAvailability(requestSlot)) {
            return "Slot marked available for date: " + requestSlot.getSlotDate()
                    + " with startTime: " + requestSlot.getSlotStartTime()
                    + "  and endTime: " + requestSlot.getSlotEndTime();
        }
        return "Slot cannot be marked as available for date: " + requestSlot.getSlotDate()
                + " with startTime: " + requestSlot.getSlotStartTime()
                + "  and endTime: " + requestSlot.getSlotEndTime();
    }

    @RequestMapping("/mark-all-slot-available")
    public String markAllSlotAvailable() {
        RequestSlot requestSlot = (RequestSlot) InterControllerMap.getUrl2ObjectMapping().get(InterControllerMap.getUrl2UrlMapping().get("/logged-in/mark-all-slot-available"));
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(InterControllerMap.getActiveUser());
        slotManagerInstance.markAllSlotsAvailable(requestSlot.getSlotDate());
        return "All slots marked as available for date: " + requestSlot.getSlotDate();
    }

    @RequestMapping("/get-all-available-slots")
    public List<RequestSlot> getAllAvailableSlots() {
        RequestSlot requestSlot = (RequestSlot) InterControllerMap.getUrl2ObjectMapping().get(InterControllerMap.getUrl2UrlMapping().get("/logged-in/get-all-available-slots"));
        SlotManagerImpl slotManagerInstance = SlotManagerImpl.getSlotManagerInstance(InterControllerMap.getActiveUser());
        return slotManagerInstance.getAllAvailableSlotForDate(requestSlot.getSlotDate());
    }
}
