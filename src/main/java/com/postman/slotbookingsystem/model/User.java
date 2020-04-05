package com.postman.slotbookingsystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CalenderSlot> calenderSlots;

    public void addCalenderSlot(CalenderSlot calenderSlot) {
        calenderSlot.setUser(this);
        this.calenderSlots.add(calenderSlot);
    }
}
