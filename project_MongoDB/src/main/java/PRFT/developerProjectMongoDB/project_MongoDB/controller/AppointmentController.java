package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Client;
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
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController extends Client{

    @Autowired
    private AppointmentRespository appointmentRespository;
    @Autowired
    private UserRepository repository;

    public static List<String> existingUsers2  = new ArrayList<String>();

    @PostMapping("/Add/") //Add an Appointment to the Database
    public ResponseEntity<?> createAppointment(@Validated @RequestBody Appointment appointment) {
        if(this.repository.userExists(appointment.getUserEmail())) {//Make sure given user Email exists in the user DB
            if(appointment.getAppointmentID()==null){ //Generate an ID
                appointment.setAppointmentID(this.appointmentRespository.generateLong());
            }
            if(appointment.getIsDeleted()==null){ //Set soft delete to false
                appointment.setIsDeleted(false);
            }
            if(appointment.getAppointmentName()==null){ //If name is null, return error
                return new ResponseEntity<>("Please enter an Appointment name that is not null", HttpStatus.BAD_REQUEST);
            }
            else if(appointment.getAppointmentType()==null){//If type is null, return error
                return new ResponseEntity<>("Please enter an Appointment Type that is not null", HttpStatus.BAD_REQUEST);

            }
            else if(appointment.getAppointmentDescription()==null){//If description is null, return error
                return new ResponseEntity<>("Please enter an Appointment Description that is not null", HttpStatus.BAD_REQUEST);

            }
            else if(appointment.getAppointmentDate()==null){//If date is null, return error
                return new ResponseEntity<>("Please enter Date that is not null", HttpStatus.BAD_REQUEST);

            }
            else if(appointment.getStartTime()==null){//If start time is null, return error
                return new ResponseEntity<>("Please enter a Start Time that is not null", HttpStatus.BAD_REQUEST);

            }
            else if(appointment.getEndTime()==null){//If end time is null, return error
                return new ResponseEntity<>("Please enter an End Time that is not null", HttpStatus.BAD_REQUEST);
            }

            Appointment save = this.appointmentRespository.save(appointment); // Save appointment to repo

            if (save == null) { // If save was not successful
                return new ResponseEntity<>("Appointment was not able to be saved", HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(save);//Return the appointment as Response Entity when saved successfully
        }

        return new ResponseEntity<>("user does not exist. Please enter a valid user Email",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/List/") //List All Appointments
    public ResponseEntity<?> getAllAppointments() {
        if(this.appointmentRespository.isEmpty()){
            return new ResponseEntity("No Appointments Available. Please add",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(this.appointmentRespository.findAll());
    }

    @GetMapping("/GetOne/{id}") //Get one Appointment by ID
    public ResponseEntity<?> getAppointment(@PathVariable Long id) {
        if (this.appointmentRespository.UUIDExists(id)) {
            Optional<Appointment> newAppt = appointmentRespository.findById(id);
//            if (newAppt == null) {
//                return new ResponseEntity<>("Given ID does not correspond to an existing appointment",HttpStatus.BAD_REQUEST);
//            }
            return ResponseEntity.ok(newAppt);
        }
        return new ResponseEntity<>("Given ID does not correspond to an existing appointment",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAppointmentByEId/{id}")//Get one Appointment by user Email-ID
    public ResponseEntity<?> getAppointmentsByEId(@PathVariable String id){
        if (this.appointmentRespository.userExists(id)) {
            List<Appointment> appointmentL = this.appointmentRespository.findByEmail(id);
            return ResponseEntity.ok(appointmentL);
        }
        return new ResponseEntity<>("Given EMAIL-ID does not correspond to an existing appointment", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/DeleteOne/{id}") //Delete one Appointment by ID
    public String deleteAppointment(@PathVariable Long id) {
        if (this.appointmentRespository.UUIDExists(id)) {
            appointmentRespository.deleteById(id);
            return "Appointment with appointment ID:" + id.toString() + " has been deleted successfully.";
        }
        return "Invalid Appointment ID - doesn't exist";
    }

    @DeleteMapping("/DeleteSoft/{id}") //Delete one Appointment by ID
    public String softDeleteAppointment(@PathVariable Long id) {
        Appointment appt = appointmentRespository.findByApptID(id);
        if (appt == null) {
            return "Appointment is null";
        }
        appt.setIsDeleted(true);
        appointmentRespository.save(appt);
        return "Appointment with ID:"+id.toString()+"has been soft deleted.";
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

    @PutMapping("/Update/{id}/{key}/{value}")
    public ResponseEntity<?> updateAppointment2(@PathVariable() Long id, @PathVariable() String key,
                                                @PathVariable() String value) {
        if (this.appointmentRespository.UUIDExists(id)) {
            Appointment toUpdate = this.appointmentRespository.findByApptID(id);
            if(key.equals("userEmail")){
                if (this.repository.userExists(value)){
                    toUpdate.setUserEmail(value);
                    Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                    return ResponseEntity.ok(toUpdate2);
                }
                else{
                    return new ResponseEntity<>("User Email does not exist", HttpStatus.BAD_REQUEST);
                }
            }
            else if(key.equals("appointmentName")){
                toUpdate.setAppointmentName(value);

                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else if(key.equals("appointmentType")){
                toUpdate.setAppointmentType(value);
                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else if(key.equals("appointmentDescription")){
                toUpdate.setAppointmentDescription(value);
                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else if(key.equals("appointmentDate")){
                toUpdate.setAppointmentDate(value);
                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else if(key.equals("startTime")){
                toUpdate.setStartTime(value);
                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else if(key.equals("endTime")){
                toUpdate.setEndTime(value);
                Appointment toUpdate2 = this.appointmentRespository.save(toUpdate);
                return ResponseEntity.ok(toUpdate2);
            }
            else{
                return new ResponseEntity<>("enter valid attribute whose " +
                        "value you want to update", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("User Id does not exist",HttpStatus.NOT_FOUND);
    }
}
