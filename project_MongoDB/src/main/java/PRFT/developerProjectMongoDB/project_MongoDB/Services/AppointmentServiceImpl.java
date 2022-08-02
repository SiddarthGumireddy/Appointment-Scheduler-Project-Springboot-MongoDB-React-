package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRespository appointmentRespository;

    public Boolean isEmpty(){
        List<AppointmentDTO> AllAppointments= appointmentRespository.findAll();
        if (AllAppointments.isEmpty()){
            return true;
        }
        return false;
    }

    public List<AppointmentDTO> findByEmail(String emailID){ //Returns Appointment Entity with the given AppointmenID
        List<AppointmentDTO> AllAppointments= appointmentRespository.findAll();
        List<AppointmentDTO> returnedAppointments= new ArrayList<>();
        for (int i = 0; i < AllAppointments.size(); i++){
            AppointmentDTO newOne = AllAppointments.get(i);
            if (newOne.getUserEmail().equals(emailID)){
                returnedAppointments.add(newOne);

            }
        }
        return returnedAppointments;
    }
    public Boolean userExists(String emailID){
        List<AppointmentDTO> AllAppointments = appointmentRespository.findAll();
        Boolean yesorno = false;
        for (int i = 0; i < AllAppointments.size(); i++) {
            AppointmentDTO newOne = AllAppointments.get(i);
            if (newOne.getUserEmail() == (emailID)) {
                yesorno = true;
            }
        }
        return yesorno;


    }

    public void deleteUserAppointments(String emailID){
        List<Long> usersAppointments = new ArrayList<>();
        List<AppointmentDTO> AllAppointments = appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            AppointmentDTO newOne = AllAppointments.get(i);
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
        List<AppointmentDTO> AllAppointments= appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            AppointmentDTO newOne = AllAppointments.get(i);
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

    public AppointmentDTO findByApptID(Long id){ //Returns Appointment Entity with the given AppointmentID
        List<AppointmentDTO> AllAppointments= appointmentRespository.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            AppointmentDTO newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                return newOne;

            }
        }
        return null;
    }

    public List<AppointmentDTO> getUserAppointments(String emailID){
        System.out.print("getUserAppointments is called \n");
        List<AppointmentDTO> usersAppointments = new ArrayList<>();
        List<AppointmentDTO> AllAppointments = appointmentRespository.findAll();
        for (AppointmentDTO newOne : AllAppointments) {
            if (newOne.getUserEmail().equals(emailID)) {
                System.out.print("appointments received\n");
                usersAppointments.add(newOne);
            }
        }
        return  usersAppointments;
    }
    public void updateUserAppointmentListViaEmail(List<AppointmentDTO> appointmentList,String emailID){
        if(appointmentList.size()!=0){
            for(AppointmentDTO currentAppointment:appointmentList){
                currentAppointment.setUserEmail(emailID);
                this.appointmentRespository.save(currentAppointment);
                ResponseEntity.ok(currentAppointment);
                return;
            }
        }
        System.out.print("There are no appointments associated with this Email Address.");
        return;
    }

    public AppointmentDTO appointmentUpdateHelper(Long id, AppointmentDTO appointment) {
        if (UUIDExists(id)) {
            appointment.setAppointmentID(id);
            Optional<AppointmentDTO> current = appointmentRespository.findById(id);
            String currentUserEmail = current.get().getUserEmail();
            String currentApptName = current.get().getAppointmentName();
            String currentApptType = current.get().getAppointmentType();
            String currentApptDesc = current.get().getAppointmentDescription();
            LocalDate currentApptDate = current.get().getAppointmentDate();
            LocalDateTime currentStartTime = current.get().getStartTime();
            LocalDateTime currentEndTime = current.get().getEndTime();
            Object currentMetaData = current.get().getMetaData();
            Boolean currentIsDeleted = current.get().getIsDeleted();
            if (appointment.getUserEmail() == null){
                if (userExists(appointment.getUserEmail())){
                    appointment.setUserEmail(currentUserEmail);
                }
                else{
                    return null;
                }
            }
            if (appointment.getIsDeleted() == null) appointment.setIsDeleted(currentIsDeleted);
            if (appointment.getAppointmentName() == null) appointment.setAppointmentName(currentApptName);
            if (appointment.getAppointmentType() == null) appointment.setAppointmentType(currentApptType);
            if (appointment.getAppointmentDescription() == null) appointment.setAppointmentDescription(currentApptDesc);
            if (appointment.getAppointmentDate() == null) appointment.setAppointmentDate(currentApptDate);
            if (appointment.getStartTime() == null) appointment.setStartTime(currentStartTime);
            if (appointment.getEndTime() == null) appointment.setEndTime(currentEndTime);
            if (appointment.getMetaData() == null) appointment.setMetaData(currentMetaData);
        }
        return null;
    }

}
