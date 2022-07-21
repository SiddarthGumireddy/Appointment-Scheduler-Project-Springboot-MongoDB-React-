package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
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
}

