package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Random;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3001")
public interface UserRepository extends MongoRepository<User, Long> {
    default Boolean UUIDExists(Long id) {
        List<User> AllUsers = this.findAll();
        for (int i = 0; i < AllUsers.size(); i++) {
            User newOne = AllUsers.get(i);
            if (newOne.getUserID().equals(id)) {
                return true;
            }
        }
        return false;

    }

    default Boolean userExists(String emailID){
        List<User> AllUsers = this.findAll();
        Boolean yesorno = false;
        for (int i = 0; i < AllUsers.size(); i++) {
            User newOne = AllUsers.get(i);
            if (newOne.getEmailID().equals(emailID)) {
                yesorno = true;
            }
        }
        return yesorno;


    }

    default User findByEmail(String emailID){ //Returns Appointment Entity with the given AppointmenID
        List<User> AllAppointments= this.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            User newOne = AllAppointments.get(i);
            if (newOne.getEmailID().equals(emailID)){
                return newOne;

            }
        }
        return AllAppointments.get(0); //change this to none
    }
    default Long generateLong(){
        Boolean isIDThere = true;
        Long newLong = new Random().nextLong(999999);
        while (isIDThere = true){
            if (UUIDExists(newLong) == false){
                isIDThere = false;
                return newLong;
            }
            newLong = new Random().nextLong();
        }
        return newLong;
    }
}

