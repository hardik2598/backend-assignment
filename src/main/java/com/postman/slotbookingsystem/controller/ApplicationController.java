package com.postman.slotbookingsystem.controller;

import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.model.User;
import com.postman.slotbookingsystem.service.SlotManagerImpl;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;

//import com.postman.slotbookingsystem.model.User;

@RestController
@RequestMapping("/logged-in")
public class ApplicationController {

    @PostMapping("/book-slot")
    public String bookSlot(@RequestBody RequestSlot requestSlot) {
        User user = User.builder()
                .username("abcd")
                .password("efgh")
                .calenderSlots(new HashSet<>())
                .build();
        SlotManagerImpl slotManager = new SlotManagerImpl(user);
        slotManager.markAllSlotsAvailable(LocalDate.now());
        slotManager.bookSlot(requestSlot);
        slotManager.markSlotAvailability(requestSlot);
        String result = slotManager.getAllAvailableSlotForDate(LocalDate.now()).size()+"";
        return result;
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping("/foo")
    public String foo() {
        return "abcd";
    }
}
