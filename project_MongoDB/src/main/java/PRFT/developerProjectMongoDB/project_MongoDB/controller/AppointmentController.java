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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @Autowired
    private UserRepository repository;


    @PostMapping("/Add/") //Add an Appointment to the DB
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        Appointment save = this.appointmentRespository.save(appointment);
        /*UUID newUserID = save.getUserID();
        Optional<User> currentUser = this.repository.findById(newUserID);
        List<Appointment> currentUserApptList = currentUser.get().getUserApptList();
        currentUserApptList.add(s);*/
        return ResponseEntity.ok(save);
    }

    @GetMapping("/List/") //List All Appointments
    public ResponseEntity<?> getAllAppointments() {
        return ResponseEntity.ok(this.appointmentRespository.findAll());
    }

    @GetMapping("/GetOne/{id}") //Get one Appointment by ID
    public Optional<Appointment> getAppointment(@PathVariable UUID id) {
        return appointmentRespository.findById(id);
    }

    @DeleteMapping("/DeleteOne/{id}") //Delete one Appointment by ID
    public String deleteAppointment(@PathVariable UUID id) {
        appointmentRespository.deleteById(id);

        return "Appointment with appointment ID:" + id.toString()+ " has been deleted successfully.";
    }

    @PutMapping("/UpdateAppointment/{id}")
    public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointment, @PathVariable() UUID id) {
        appointmentRespository.deleteById(id);
        Appointment save = this.appointmentRespository.save(appointment);
        return ResponseEntity.ok(save);
    }
}
