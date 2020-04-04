package com.postman.slotbookingsystem.service;

import com.postman.slotbookingsystem.model.CalenderSlot;
import com.postman.slotbookingsystem.model.RequestSlot;
import com.postman.slotbookingsystem.model.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SlotManagerImpl implements SlotManager {

    private static SlotManagerImpl slotManagerInstance = null;
    private User currentUser;
    private Set<CalenderSlot> calenderSlots;

    private SlotManagerImpl(User currentUser) {
        this.currentUser = currentUser;
        calenderSlots = this.currentUser.getCalenderSlots();
    }

    public static SlotManagerImpl getSlotManagerInstance(User currentUser) {
        if (slotManagerInstance == null)
            return new SlotManagerImpl(currentUser);
        return slotManagerInstance;
    }

    private Set<CalenderSlot> getSlotsOfCurrentUser() {
        return currentUser.getCalenderSlots();
    }

    @Override
    public boolean checkAvailabilityOfSlot(RequestSlot requestSlot) {
        calenderSlots = getSlotsOfCurrentUser();
        Optional<CalenderSlot> result = calenderSlots.stream().filter(calenderSlot -> {
            return calenderSlot.getSlotDate().equals(requestSlot.getSlotDate())
                    && calenderSlot.getSlotStartTime().equals(requestSlot.getSlotStartTime())
                    && calenderSlot.getSlotEndTime().equals(requestSlot.getSlotEndTime())
                    && calenderSlot.getSlotStatus().equals("booked");
        }).findAny();
        return !result.isPresent();
    }

    @Override
    public boolean bookSlot(RequestSlot requestSlot) {
        if (checkAvailabilityOfSlot(requestSlot)) {
            CalenderSlot calenderSlot = getCalenderSlot(requestSlot);
            calenderSlot.setSlotStatus("booked");
            currentUser.addCalenderSlot(calenderSlot);
            return true;
        }
        return false;
    }

    private CalenderSlot getCalenderSlot(RequestSlot requestSlot) {
        calenderSlots = getSlotsOfCurrentUser();
        List<CalenderSlot> slotList = calenderSlots.stream().filter(calenderSlot -> {
            return calenderSlot.getSlotDate().equals(requestSlot.getSlotDate())
                    && calenderSlot.getSlotStartTime().equals(requestSlot.getSlotStartTime())
                    && calenderSlot.getSlotEndTime().equals(requestSlot.getSlotEndTime());
        }).collect(Collectors.toList());
        if (slotList.size() == 0)
            return buildNewcalenderSlot(requestSlot);
        return slotList.get(0);
    }

    private CalenderSlot buildNewcalenderSlot(RequestSlot requestSlot) {
        return CalenderSlot.builder()
                .slotDate(requestSlot.getSlotDate())
                .slotStartTime(requestSlot.getSlotStartTime())
                .slotEndTime(requestSlot.getSlotEndTime())
                .build();
    }

    @Override
    public boolean markSlotAvailability(RequestSlot requestSlot) {
        if (checkAvailabilityOfSlot(requestSlot)) {
            CalenderSlot calenderSlot = getCalenderSlot(requestSlot);
            calenderSlot.setSlotStatus("available");
            return true;
        }
        return false;
    }

    @Override
    public void markAllSlotsAvailable(LocalDate date) {
        Set<CalenderSlot> slotSet = new HashSet<>();
        RequestSlot requestSlot;
        for (int i = 0; i < 24; i++) {
            requestSlot = RequestSlot.builder()
                    .slotDate(date)
                    .slotStartTime((i < 10 ? "0" + i : i) + ":00")
                    .slotEndTime(((i + 1) < 10 ? "0" + (i + 1) : (i + 1)) + ":00")
                    .build();
            CalenderSlot newSlot = getCalenderSlot(requestSlot);
            newSlot.setSlotStatus("available");
            slotSet.add(newSlot);
        }
        currentUser.setCalenderSlots(slotSet);
    }

    @Override
    public List<RequestSlot> getAllAvailableSlotForDate(LocalDate date) {
        calenderSlots = getSlotsOfCurrentUser();
        return calenderSlots.stream().filter(calenderSlot -> {
            return calenderSlot.getSlotDate().equals(date)
                    && calenderSlot.getSlotStatus().equals("available");
        }).map(calenderSlot -> buildRequestSlot(calenderSlot)).collect(Collectors.toList());
    }

    private RequestSlot buildRequestSlot(CalenderSlot calenderSlot) {
        return RequestSlot.builder()
                .slotDate(calenderSlot.getSlotDate())
                .slotStartTime(calenderSlot.getSlotStartTime())
                .slotEndTime(calenderSlot.getSlotEndTime())
                .build();
    }
}
