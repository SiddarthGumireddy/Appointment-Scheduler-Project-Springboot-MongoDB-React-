package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID>{

}

