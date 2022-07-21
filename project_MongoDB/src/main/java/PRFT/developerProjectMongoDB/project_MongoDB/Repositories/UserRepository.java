package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

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

