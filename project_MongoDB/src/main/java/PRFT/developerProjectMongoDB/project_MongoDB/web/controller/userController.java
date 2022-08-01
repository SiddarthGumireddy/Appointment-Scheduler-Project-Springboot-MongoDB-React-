package PRFT.developerProjectMongoDB.project_MongoDB.web.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.AppointmentService;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.AppointmentServiceImpl;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.UserService;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class userController{
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRespository appointmentRespository;
    @PostMapping("/addUser")

    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (service.userExists(user.getEmailID())){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
       if(user.getUserID()==null){
           user.setUserID(service.generateLong());
       }
        User save = repository.save(user);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/ListAllUsers")
    public ResponseEntity<?>ListUsers(){
        if(this.service.isEmpty()){
            return new ResponseEntity("No Users exist",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(this.repository.findAll());
//        List<User> UserResults = null;
//        for(User user:AllUsers){
//            if(!user.getIsDeleted()){
//                assert false;
//                UserResults.add(user);
//            }
//        }
//        return ResponseEntity.ok(UserResults);
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){

        if (this.service.UUIDExists(id)) {
            Optional<User> user = repository.findById(id);
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>("Invalid ID",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserByEId/{id}")
    public ResponseEntity<?> getUserByEId(@PathVariable String id){
        if (this.service.userExists(id)) {
            User user = service.findByEmail(id);
            if (user == null) {
                return new ResponseEntity<>("User doesn't exist with this Email",HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>("Invalid Email",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        if (this.service.UUIDExists(id)) {
            String emailID = (service.getEmailfromID(id));
            this.appointmentService.deleteUserAppointments(emailID);
            repository.deleteById(id);
            return "User with UserID:" + id + ", and their appointments have been deleted!";
        }
        return "Invalid User ID, Please Try Again!";
    }
    @DeleteMapping("/SoftDelete/{id}") //Soft Delete User via ID
    public String softDeleteUser(@PathVariable Long id) {
        User user = service.findByUserID(id);
        if (user == null) {
            return "User doesn't exist, please enter a valid ID";
        }
        user.setIsDeleted(true);
        repository.save(user);
        return "User with ID:"+id.toString()+" has been soft deleted!";
    }
    @GetMapping("/getUserAppointments/{emailID}")
    public ResponseEntity<?> getUserAppointments(String emailID){
        if(service.userExists(emailID)) {
            List<AppointmentDTO> usersAppointments = new ArrayList<>();
            List<AppointmentDTO> AllAppointments = appointmentRespository.findAll();
            for (AppointmentDTO newOne : AllAppointments) {
                if (newOne.getUserEmail().equals(emailID)) {
                    usersAppointments.add(newOne);
                }
            }
            return ResponseEntity.ok(usersAppointments);
        }
        else{
           return new ResponseEntity<>("Invalid Email Address, Please try again with a valid email.",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> updateUserAppointments(List<Appointment> appointmentList, String Email){
        if(appointmentList.size()!=0){
            for(Appointment currentAppt:appointmentList){
                currentAppt.setUserEmail(Email);
                return ResponseEntity.ok(currentAppt);
            }
        }
        return new ResponseEntity<>("There are no appointments associated with this Email Address.", HttpStatus.BAD_REQUEST);
    }
    public void userUpdateHelper(Long id, String key, String value){
        if (this.service.UUIDExists(id)) {
            User toUpdate = this.service.findByUserID(id);

            if(key.equals("emailID")){
                String OGEmail = toUpdate.getEmailID();
                toUpdate.setEmailID(value);
                User toUpdate2 = this.repository.save(toUpdate);
                if(this.appointmentService.isEmpty()==false) {
                    List<AppointmentDTO> UserAppointmentList = this.appointmentService.getUserAppointments(OGEmail);
                    appointmentService.updateUserAppointmentListViaEmail(UserAppointmentList, value);
                    ResponseEntity.ok(toUpdate2);
                }
                return;
            }
            else if(key.equals("firstName")){
                toUpdate.setFirstName(value);
                User toUpdate2 = this.repository.save(toUpdate);
                ResponseEntity.ok(toUpdate2);
                return;
            }
            else if(key.equals("lastName")){
                toUpdate.setLastName(value);
                User toUpdate2 = this.repository.save(toUpdate);
                ResponseEntity.ok(toUpdate2);
                return;
            }
            else if(key.equals("age")){
                toUpdate.setAge(value);
                User toUpdate2 = this.repository.save(toUpdate);
                ResponseEntity.ok(toUpdate2);
                return;
            }
            else if(key.equals("gender")){
                toUpdate.setGender(value);
                User toUpdate2 = this.repository.save(toUpdate);
                ResponseEntity.ok(toUpdate2);
                return;
            }
            else if(key.equals("phoneNumber")){
                toUpdate.setPhoneNumber(value);
                User toUpdate2 = this.repository.save(toUpdate);
                ResponseEntity.ok(toUpdate2);
                return;
            }

            else{
                new ResponseEntity<>("enter valid key for the respective " +
                        "value you would like to update", HttpStatus.BAD_REQUEST);
                return;
            }
        }
        new ResponseEntity<>("User ID does not exist, Please enter a valid one.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/Update/{id}/{userkeys}/{uservalues}")
    public ResponseEntity<?> updateUser(@PathVariable() Long id, @PathVariable() String userkeys,
                                        @PathVariable() String uservalues) {
        List<String> keys = List.of(userkeys.split(","));
        List<String> values = List.of(uservalues.split(","));
        if (keys.size() == values.size()) {
            for (int i = 0; i < keys.size(); i++){
                userUpdateHelper(id,keys.get(i), values.get(i));
            }
            return ResponseEntity.ok("User Updated");
        }
        else{
            return new ResponseEntity<>("The size of keys and values aren't the same, please try again.", HttpStatus.BAD_REQUEST);
        }
    }
}
