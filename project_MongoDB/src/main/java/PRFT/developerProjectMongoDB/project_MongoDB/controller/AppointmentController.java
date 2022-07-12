package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @PostMapping("/Add/") //Add an Appointment to the DB
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        Appointment save = this.appointmentRespository.save(appointment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/GetAll/") //List All Appointments
    public ResponseEntity<?> getAllAppointments(){
    return ResponseEntity.ok(this.appointmentRespository.findAll());
    }

    @GetMapping("/GetOne/") //Get one Appointment by ID
    public ResponseEntity<?> getAppointment(@RequestBody String apptID){
        UUID apptID2 = UUID.fromString(apptID);
        return ResponseEntity.ok(this.appointmentRespository.findById(apptID2));
    }
}
