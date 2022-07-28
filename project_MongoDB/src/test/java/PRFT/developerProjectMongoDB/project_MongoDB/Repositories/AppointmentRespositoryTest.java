package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.controller.AppointmentController;
import PRFT.developerProjectMongoDB.project_MongoDB.controller.userController;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class AppointmentRespositoryTest {
    private static String URL = "/api/v1/appointment";
    private static long ApptID = 10L;

    @Mock
    AppointmentRespository appointmentRespository;

    @Mock
    UserRepository repository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    AppointmentController appointmentController;
    @InjectMocks
    userController controller;

    Long IDNEW2 = Long.valueOf(821159);

    Appointment getValidAppt() {
        return Appointment.builder()
                .appointmentID(IDNEW2)
                .userEmail("Sid@gmail.com")
                .appointmentName("Dental")
                .appointmentType("1 HOUR")
                .appointmentDescription("Desc1")
                .appointmentDate("24th Feb 2022")
                .startTime("9AM")
                .endTime("9AM")
                .metaData(null)
                .build();
    }



    User getValidUser() {
        return User.builder()
                .userID(10L)
                .firstName("Sid@gmail.com")
                .lastName("Dental")
                .gender("1 HOUR")
                .age("Desc1")
                .emailID("24th Feb 2022")
                .phoneNumber("9AM")
                .build();
    }

    List<Appointment> getValidApptList() {
        List<Appointment> apptsList = new ArrayList<>();
        apptsList.add(getValidAppt());
        apptsList.add(getValidAppt());
        return apptsList;
    }
    List<User> getValidUserList() {
        List<User> usersList = new ArrayList<>();
        usersList.add(getValidUser());
        usersList.add(getValidUser());
        return usersList;
    }
    @Test
    void isEmpty() {
        this.appointmentController.createAppointment(getValidAppt());
        assertThat(this.appointmentRespository.isEmpty()).isEqualTo(false);
    }

    @Test
    void generateLong(){
        Long gen = this.appointmentRespository.generateLong();
        Boolean b1 = this.appointmentRespository.UUIDExists(gen);
        Boolean b2 = false;
        assertThat(b1).isEqualTo(b2);
    }

    @Test
    void UUIDExists(){
//        this.appointmentController.createAppointment(getValidAppt());
        Boolean b1 = false;
        Boolean b2 = this.appointmentRespository.UUIDExists(getValidAppt().getAppointmentID());
        assertThat(b1).isEqualTo(b2);
    }


    @Test
    void testIsEmpty() {
        this.appointmentController.createAppointment(getValidAppt());
        assertThat(this.appointmentRespository.isEmpty()).isEqualTo(false);
    }

    @Test
    void testUUIDExists() {
        Boolean b1 = false;
        Boolean b2 = this.appointmentRespository.UUIDExists(getValidAppt().getAppointmentID());
        assertThat(b1).isEqualTo(b2);
    }

    @Test
    void testGenerateLong() {
        Long gen = this.appointmentRespository.generateLong();
        Boolean b1 = this.appointmentRespository.UUIDExists(gen);
        Boolean b2 = false;
        assertThat(b1).isEqualTo(b2);
    }

    @BeforeEach
    void setUp() {
    }
}