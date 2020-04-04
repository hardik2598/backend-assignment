package com.postman.slotbookingsystem.controller;

import com.postman.slotbookingsystem.model.CalenderSlot;
import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.model.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

//import com.postman.slotbookingsystem.model.User;

@RestController
@RequestMapping("/logged-in")
public class ApplicationController {

    @PostMapping("/book-slot")
    public String hello(@RequestBody RequestSlot requestSlot) {
        return requestSlot.toString();
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping("/foo")
    public String foo() {
        CalenderSlot slot1 = new CalenderSlot();
        slot1.setId(1L);
        slot1.setSlotDate(LocalDate.now());
        slot1.setSlotStartTime("01:00");
        slot1.setSlotEndTime("02:00");
        CalenderSlot slot2 = new CalenderSlot();
        slot1.setId(2L);
        slot1.setSlotDate(LocalDate.now());
        slot1.setSlotStartTime("01:00");
        slot1.setSlotEndTime("02:00");
        System.out.println(slot1.equals(slot2));
        return "abcd";
    }
}
