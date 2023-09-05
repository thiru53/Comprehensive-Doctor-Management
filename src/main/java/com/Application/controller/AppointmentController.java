package com.Application.controller;

import com.Application.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
}
