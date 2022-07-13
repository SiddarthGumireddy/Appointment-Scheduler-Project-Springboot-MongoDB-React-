package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface AppointmentRespository extends MongoRepository<Appointment, UUID> {


    default Appointment findByApptID(UUID id){
        List<Appointment> AllAppointments= this.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                return newOne;

            }
        }
        return AllAppointments.get(0); //change this to none
    }

    default void deleteByApptId(UUID id){
        List<Appointment> AllAppointments= this.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                Appointment newOne2 = newOne;
                this.delete(newOne2);
            }
        }
    }

    default List<Appointment> getAllExcept(UUID apptID) {
        int index2 = 0;
        List<Appointment> AllAppointments= this.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(apptID)){
                index2 = i;
            }
        }
        AllAppointments.remove(index2);
        return AllAppointments;
    }


}
