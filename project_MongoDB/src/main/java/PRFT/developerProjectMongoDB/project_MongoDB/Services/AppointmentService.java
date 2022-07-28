package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface AppointmentService {

    Boolean isEmpty();

    List<AppointmentDTO> findByEmail(String emailID);

    Boolean userExists(String emailID);

    void deleteUserAppointments(String emailID);

    List getUserAppointments(String emailID);

    void updateUserAppointmentListViaEmail(List<AppointmentDTO> appointmentList,String emailID);

    void deleteAppointments(List<Long> usersAppointments);

    Boolean UUIDExists(Long id);

    Long generateLong();

    AppointmentDTO findByApptID(Long id);

}
