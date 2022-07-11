package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AppointmentRespository extends MongoRepository<Appointment, Integer> {

}
