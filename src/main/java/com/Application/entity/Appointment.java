package com.Application.entity;


import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Appointment {

    Long id;
    String name;
    String email;
    String specialization;
    List<Schedule> weeklySchedule;

}
