package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment){
        Appointment save = this.appointmentRespository.save(appointment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllAppointments(){
        return ResponseEntity.ok(this.appointmentRespository.findAll());
    }
}
