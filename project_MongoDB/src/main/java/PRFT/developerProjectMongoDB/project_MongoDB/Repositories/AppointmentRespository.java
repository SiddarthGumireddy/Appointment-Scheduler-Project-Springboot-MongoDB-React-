package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@org.springframework.stereotype.Repository
public interface AppointmentRespository extends MongoRepository<AppointmentDTO, Long>{

    }

