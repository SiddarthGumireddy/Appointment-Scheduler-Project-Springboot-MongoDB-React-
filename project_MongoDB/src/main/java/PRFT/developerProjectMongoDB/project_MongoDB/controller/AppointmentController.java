package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/v1/appointment")
@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class AppointmentController {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @Autowired
    private UserRepository repository;


    @PostMapping("/Add/") //Add an Appointment to the DB
    public ResponseEntity<?> createAppointment(@Validated @RequestBody Appointment appointment) {
        if(appointment.getAppointmentID()==null){
            appointment.setAppointmentID(this.appointmentRespository.generateLong());
        }
        if(repository.userExists(appointment.getUserEmail())) {
            Appointment save = this.appointmentRespository.save(appointment);

            if (save == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(save);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//jsr303
    @GetMapping("/List/") //List All Appointments
    public ResponseEntity<?> getAllAppointments() {
        if(this.appointmentRespository.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(this.appointmentRespository.findAll());
    }



    @GetMapping("/GetOne/{id}") //Get one Appointment by ID
    public ResponseEntity<?> getAppointment(@PathVariable Long id) {
        if (this.appointmentRespository.UUIDExists(id)) {
            Optional<Appointment> newAppt = appointmentRespository.findById(id);
            if (newAppt == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(newAppt);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/DeleteOne/{id}") //Delete one Appointment by ID
    public String deleteAppointment(@PathVariable Long id) {
        if (this.appointmentRespository.UUIDExists(id)) {
            appointmentRespository.deleteById(id);
            return "Appointment with appointment ID:" + id.toString() + " has been deleted successfully.";
        }
        return "Invalid Appointment ID - doesn't exist";
    }

    @PutMapping("/UpdateAppointment/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable() Long id,@RequestBody Appointment appointment) {
        if (this.appointmentRespository.UUIDExists(id)) {
            appointmentRespository.deleteById(id);
            Appointment save = this.appointmentRespository.save(appointment);
            return ResponseEntity.ok(save);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
