package PRFT.developerProjectMongoDB.project_MongoDB.web.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.AppointmentService;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.AppointmentServiceImpl;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
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
@CrossOrigin(origins = "*")
public class userController{
    @Autowired
    private UserRepository repository;

    @Autowired
    private AppointmentRespository appointmentRespository;

@Autowired
    private AppointmentService appointmentService;

@Autowired
    private AppointmentServiceImpl appointmentServiceImpl;

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
            String emailID = (repository.getEmailfromID(id));
            this.appointmentService.deleteUserAppointments(emailID);
            repository.deleteById(id);
            return "User with UserID:" + id + ", and their appointments have been deleted!";
        }
        return "Invalid User ID, Please Try Again!";
    }
    @PutMapping("/UpdateDyn/{id}/{userkeys}/{uservalues}")
    public ResponseEntity<?> updateUser2(@PathVariable() Long id, @PathVariable() String userkeys, @PathVariable() String uservalues) {
        List<String> keys = List.of(userkeys.split(","));
        List<String> values = List.of(uservalues.split(","));
        if (this.repository.UUIDExists(id)) {
            User currentUser = this.repository.findByUserID(id);
            User updatedUser = this.repository.save(currentUser);
            int i = 0;
            while (i < keys.size()) {
                if (keys.get(i).equals("emailID")) {
                    currentUser.setEmailID(values.get(i));
                    List UserAppointmentList = this.appointmentService.getUserAppointments(values.get(i));
                    if (UserAppointmentList.size() != 0) {
                        appointmentService.updateUserAppointmentListViaEmail(UserAppointmentList, values.get(i));}
                } else if (keys.get(i).equals("firstName")) {
                    currentUser.setFirstName(values.get(i));
                } else if (keys.get(i).equals("lastName")) {
                    currentUser.setLastName(values.get(i));
                } else if (keys.get(i).equals("age")) {
                    currentUser.setAge(values.get(i));
                } else if (keys.get(i).equals("gender")) {
                    currentUser.setGender(values.get(i));
                } else if (keys.get(i).equals("phoneNumber")) {
                    currentUser.setPhoneNumber(values.get(i));
                } else {
                    return new ResponseEntity<>("enter valid user key for whose " +
                            "value you would like to update", HttpStatus.BAD_REQUEST);
                }
                i++;
            }
            return ResponseEntity.ok(updatedUser);
        }
        return new ResponseEntity<>("User ID does not exist", HttpStatus.NOT_FOUND);
    }
}
