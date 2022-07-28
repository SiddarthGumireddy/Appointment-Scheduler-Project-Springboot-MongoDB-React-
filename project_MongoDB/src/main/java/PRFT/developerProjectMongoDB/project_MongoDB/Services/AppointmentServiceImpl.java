package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRespository appointmentRespository;

    public Boolean isEmpty(){
        List<Appointment> AllAppointments= appointmentRespository.findAll();
        if (AllAppointments.isEmpty()){
            return true;
        }
        return false;
    }

    public List<Appointment> findByEmail(String emailID){ //Returns Appointment Entity with the given AppointmenID
        List<Appointment> AllAppointments= appointmentRespository.findAll();
        List<Appointment> returnedAppointments= new ArrayList<>();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getUserEmail().equals(emailID)){
                returnedAppointments.add(newOne);

            }
        }
        return returnedAppointments;
    }
    public Boolean userExists(String emailID){
        List<Appointment> AllAppointments = appointmentRespository.findAll();
        Boolean yesorno = false;
        for (int i = 0; i < AllAppointments.size(); i++) {
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getUserEmail() == (emailID)) {
                yesorno = true;
            }
        }
        return yesorno;


    }

    public void deleteUserAppointments(String emailID){
        List<Long> usersAppointments = new ArrayList<>();
        List<Appointment> AllAppointments = appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getUserEmail().equals(emailID)){
                usersAppointments.add(newOne.getAppointmentID());
            }
        }
        deleteAppointments(usersAppointments);
    }


    public void deleteAppointments(List<Long> usersAppointments){
        for (int i = 0; i < usersAppointments.size();i ++){
            appointmentRespository.deleteById(usersAppointments.get(i));
        }
    }

    public Boolean UUIDExists(Long id){
        List<Appointment> AllAppointments= appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                return true;
            }
        }
        return false;
    }
    public Long generateLong(){
        boolean isIDThere = true;
        Long newLong = new Random().nextLong(999999);
        while (true){
            if (!UUIDExists(newLong)){
                isIDThere = false;
                return newLong;
            }
            newLong = new Random().nextLong();
        }
    }

    public Appointment findByApptID(Long id){ //Returns Appointment Entity with the given AppointmentID
        List<Appointment> AllAppointments= appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                return newOne;

            }
        }
        return null;
    }

    public List getUserAppointments(String emailID){
        List<Appointment> usersAppointments = new ArrayList<>();
        List<Appointment> AllAppointments = appointmentRespository.findAll();
        for (Appointment newOne : AllAppointments) {
            if (newOne.getUserEmail().equals(emailID)) {
                usersAppointments.add(newOne);
            }
        }
        return  usersAppointments;
    }
    public void updateUserAppointmentListViaEmail(List<Appointment> appointmentList,String emailID){
        for (Appointment appointment : appointmentList) {
            appointment.setUserEmail(emailID);
        }
    }

}
