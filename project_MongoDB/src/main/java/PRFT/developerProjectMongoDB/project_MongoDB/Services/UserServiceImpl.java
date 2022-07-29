package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    public boolean UUIDExists(Long id) {
        List<User> AllUsers = this.repository.findAll();
        for (User newOne : AllUsers) {
            if (newOne.getUserID().equals(id)) {
                return true;
            }
        }
        return false;

    }
    public Boolean isEmpty(){
        List<User> AllUsers= this.repository.findAll();
        if (AllUsers.isEmpty()){
            return true;
        }
        return false;
    }


    public Boolean userExists(String emailID){
        List<User> AllUsers = this.repository.findAll();
        boolean yesorno = false;
        for (int i = 0; i < AllUsers.size(); i++) {
            User newOne = AllUsers.get(i);
            if (newOne.getEmailID().equals(emailID)) {
                yesorno = true;
            }
        }
        return yesorno;


    }

    @Override
    public void deleteUserAppointments(String emailID) {

    }

    public User findByEmail(String emailID){ //Returns User Entity with the given emailID
        List<User> AllUsers= repository.findAll();
        List<User> returnedUsers= new ArrayList<>();
        for (int i = 0; i < AllUsers.size(); i++){
            User newUser = AllUsers.get(i);
            if (newUser.getEmailID().equals(emailID)){
                returnedUsers.add(newUser);

            }
        }
        return (User) returnedUsers;
    }

    public Long generateLong(){
        Boolean isIDThere = true;
        Long newLong = new Random().nextLong(999999);
        while (isIDThere = true){
            if (!UUIDExists(newLong)){
                isIDThere = false;
                return newLong;
            }
            newLong = new Random().nextLong();
        }
        return newLong;
    }
    public User findByUserID(Long id){ //Returns User Entity with the given UserId
        List<User> AllUsers= this.repository.findAll();
        for (int i = 0; i < AllUsers.size(); i++){
            User newUser = AllUsers.get(i);
            if (newUser.getUserID().equals(id)){
                return newUser;
            }
        }
        return null;
    }

    public String getEmailfromID(Long id){
        List<User> AllUsers= this.repository.findAll();
        for (int i = 0; i < AllUsers.size(); i++){
            User newOne = AllUsers.get(i);
            if (newOne.getUserID().equals(id)){
                return newOne.getEmailID();

            }
            else {
                continue;
            }
        }
        return "user does not exist";
    }
}

