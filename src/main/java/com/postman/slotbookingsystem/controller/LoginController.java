package com.postman.slotbookingsystem.controller;

import com.postman.slotbookingsystem.model.InterControllerMap;
import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.model.RequestUser;
import com.postman.slotbookingsystem.model.User;
import com.postman.slotbookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/postman")
public class LoginController {

    private static User activeUser;
    @Autowired
    UserRepository userRepository;
    private Map<String, String> url2UrlMapping;
    private Map<String, Object> url2ObjectMapping;

    public static User getActiveUser() {
        return activeUser;
    }

    @Bean
    public void mapInit() {
        url2UrlMapping = InterControllerMap.getUrl2UrlMapping();
        url2ObjectMapping = InterControllerMap.getUrl2ObjectMapping();
    }

    @PostMapping("/login")
    public String login(@RequestBody RequestUser requestUser) {
        User activeUser = userRepository.findByUsername(requestUser.getUsername());
        if (activeUser.getPassword().equals(requestUser.getPassword())) {
            this.activeUser = activeUser;
            return "Successfully LoggedIn";
        }
        return "LogIn Failed";
    }

    @RequestMapping("/book-slot")
    public ModelAndView bookSlot(@RequestBody RequestSlot requestSlot) {
        url2UrlMapping.put("/book-slot", "/logged-in/book-slot");
        url2ObjectMapping.put("/book-slot", requestSlot);
        return new ModelAndView("redirect:/logged-in/book-slot");
    }

    @RequestMapping("/check-slot-availability")
    public ModelAndView checkSlotAvailability(@RequestBody RequestSlot requestSlot) {
        url2UrlMapping.put("/check-slot-availability", "/logged-in/check-slot-availability");
        url2ObjectMapping.put("/check-slot-availability", requestSlot);
        return new ModelAndView("redirect:/logged-in/check-slot-availability");
    }

    @RequestMapping("/mark-slot-available")
    public ModelAndView markSlotAvailable(@RequestBody RequestSlot requestSlot) {
        url2UrlMapping.put("/mark-slot-available", "/logged-in/mark-slot-available");
        url2ObjectMapping.put("/mark-slot-available", requestSlot);
        return new ModelAndView("redirect:/logged-in/mark-slot-available");
    }

    @RequestMapping("/mark-all-slot-available")
    public ModelAndView markAllSlotAvailable(@RequestBody RequestSlot requestSlot) {
        url2UrlMapping.put("/mark-all-slot-available", "/logged-in/mark-all-slot-available");
        url2ObjectMapping.put("/mark-all-slot-available", requestSlot);
        return new ModelAndView("redirect:/logged-in/mark-all-slot-available");
    }

    @RequestMapping("/get-all-available-slots")
    public ModelAndView getAllAvailableSlots(@RequestBody RequestSlot requestSlot) {
        url2UrlMapping.put("/get-all-available-slots", "/logged-in/get-all-available-slotsv");
        url2ObjectMapping.put("/get-all-available-slots", requestSlot);
        return new ModelAndView("redirect:/logged-in/get-all-available-slots");
    }
}
