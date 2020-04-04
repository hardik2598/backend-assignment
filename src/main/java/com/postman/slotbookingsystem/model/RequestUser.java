package com.postman.slotbookingsystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RequestUser {
    private String username;

    private String password;
}
