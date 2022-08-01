package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Lazy
    private UserService service;
    @Autowired
    private AppointmentService appointmentService;

    public boolean UUIDExists(Long id) {
        List<User> AllUsers = this.repository.findAll();
        for (User newOne : AllUsers) {
            if (newOne.getUserID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isEmpty() {
        List<User> AllUsers = this.repository.findAll();
        return AllUsers.isEmpty();
    }


    public Boolean userExists(String emailID) {
        List<User> AllUsers = this.repository.findAll();
        boolean found = false;
        for (User user : AllUsers) {
            if (user.getEmailID().equals(emailID)) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public void deleteUserAppointments(String emailID) {

    }

    public void userUpdateHelper(Long id, String key, String value){
        if (this.appointmentService.UUIDExists(id)) {
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


    @Override
    public User findByEmail(String emailID) {
        List<User> AllUsers = repository.findAll();
        List<User> returnedUsers = new ArrayList<>();
        for (User user : AllUsers) {
            if (user.getEmailID().equals(emailID)) {
                returnedUsers.add(user);
            }
        }
        return (User) returnedUsers;
    }


    public Long generateLong() {
        Boolean IDExists = true;
        Long newLong = new Random().nextLong(999999);
        while (IDExists = true) {
            if (!UUIDExists(newLong)) {
                IDExists = false;
                return newLong;
            }
            newLong = new Random().nextLong();
        }
        return newLong;
    }

    public User findByUserID(Long id) { //Returns User with the given UserId
        List<User> AllUsers = this.repository.findAll();
        for (User user : AllUsers) {
            if (user.getUserID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String getEmailfromID(Long id) {
        List<User> AllUsers = this.repository.findAll();
        for (User user : AllUsers) {
            if (user.getUserID().equals(id)) {
                return user.getEmailID();
            }
        }
        return "User does not exist";
    }
}

