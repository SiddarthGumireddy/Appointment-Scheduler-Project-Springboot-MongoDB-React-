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
import java.util.Optional;
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
    public User findByEmail(String emailID) {
        List<User> AllUsers = repository.findAll();
        for (User user : AllUsers) {
            if (user.getEmailID().equals(emailID)) {
                return user;
            }
        }
        System.out.print("User doesn't exist with this emailID");
        return null;
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

    public User userUpdateHelper(Long id, User user) {
        if (UUIDExists(id)) {
            user.setUserID(id);
            Optional<User> current = repository.findById(id);
            String currentEmail = current.get().getEmailID();
            String currentAge = current.get().getAge();
            String currenFirstName = current.get().getFirstName();
            String currentLastName = current.get().getLastName();
            String currentPhone = current.get().getPhoneNumber();
            Boolean currentIsDeleted = current.get().getIsDeleted();
            String currentGender = current.get().getGender();
            if (user.getAge() == null) user.setAge(currentAge);
            if (user.getIsDeleted() == null) user.setIsDeleted(currentIsDeleted);
            if (user.getGender() == null) user.setGender(currentGender);
            if (user.getFirstName() == null) user.setFirstName(currenFirstName);
            if (user.getLastName() == null) user.setLastName(currentLastName);
            if (user.getPhoneNumber() == null) user.setPhoneNumber(currentPhone);
            if (user.getEmailID() == null) {
                user.setEmailID(currentEmail);
            }
            if (!this.appointmentService.isEmpty()) {
                List<AppointmentDTO> UserAppointmentList = this.appointmentService.getUserAppointments(currentEmail);
                appointmentService.updateUserAppointmentListViaEmail(UserAppointmentList, user.getEmailID());

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

