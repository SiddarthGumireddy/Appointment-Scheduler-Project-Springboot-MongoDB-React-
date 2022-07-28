package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class userController{
    @Autowired
    private UserRepository repository;

    @Autowired
    private AppointmentRespository appointmentRespository;

    @PostMapping("/addUser")
//Add an Appointment to the DB
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (repository.userExists(user.getEmailID())){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
       if(user.getUserID()==null){
           user.setUserID(repository.generateLong());
       }
        User save = repository.save(user);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/ListAllUsers")
    public ResponseEntity<?>ListUsers(){
        if(this.repository.isEmpty()){
            return new ResponseEntity("No Users exist",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(this.repository.findAll());
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){

        if (this.repository.UUIDExists(id)) {
            Optional<User> user = repository.findById(id);
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>("Invalid ID",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserByEId/{id}")
    public ResponseEntity<?> getUserByEId(@PathVariable String id){
        if (this.repository.userExists(id)) {
            User user = repository.findByEmail(id);
            if (user == null) {
                return new ResponseEntity<>("User doesn't exist with this Email",HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>("Invalid Email",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        if (this.repository.UUIDExists(id)) {
//
//            String emailID = (repository.getEmailfromID(id));
//            if(this.appointmentRespository.userExists(emailID)) {
//                this.appointmentRespository.deleteUserAppointments(emailID);
//            }
            repository.deleteById(id);
            return "User with UserID:" + id + ", and their appointments have been deleted!";
        }
        return "Invalid User ID, Please Try Again!";
    }
    @PutMapping("/Update/{id}/{key}/{value}")
    public ResponseEntity<?> updateUser(@PathVariable() Long id, @PathVariable() String key, @PathVariable() String value) {
        if (this.repository.UUIDExists(id)) {
            User currentUser = this.repository.findByUserID(id);
            if (key.equals("emailID")){
                if (this.repository.userExists(value)){
                    currentUser.setEmailID(value);
                    User updatedUser = this.repository.save(currentUser);
                    List UserAppointmentList=this.appointmentRespository.getUserAppointments(value);
                    appointmentRespository.updateUserAppointmentListViaEmail(UserAppointmentList,value);
                    return ResponseEntity.ok(updatedUser);
                }
                else{
                    return new ResponseEntity<>("User Email does not exist", HttpStatus.BAD_REQUEST);
                }
            }
            else if(key.equals("firstName")){
                currentUser.setFirstName(value);
                User updatedUser = this.repository.save(currentUser);
                return ResponseEntity.ok(updatedUser);
            }
            else if(key.equals("lastName")){
                currentUser.setLastName(value);
                User updatedUser = this.repository.save(currentUser);
                return ResponseEntity.ok(updatedUser);
            }
            else if(key.equals("age")){
                currentUser.setAge(value);
                User updatedUser = this.repository.save(currentUser);
                return ResponseEntity.ok(updatedUser);
            }
            else if(key.equals("gender")){
                currentUser.setGender(value);
                User updatedUser = this.repository.save(currentUser);
                return ResponseEntity.ok(updatedUser);
            }
            else if(key.equals("phoneNumber")){
                currentUser.setPhoneNumber(value);
                User updatedUser = this.repository.save(currentUser);
                return ResponseEntity.ok(updatedUser);
            }
            else{
                return new ResponseEntity<>("enter valid user key for whose " +
                        "value you would like to update", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("User ID does not exist",HttpStatus.NOT_FOUND);
    }
}
