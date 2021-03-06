package com.postman.slotbookingsystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class RequestSlot {
    private LocalDate slotDate;

    private String slotStartTime;

    private String slotEndTime;
}
