package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.AppointmentService;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.UserService;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import PRFT.developerProjectMongoDB.project_MongoDB.model.AppointmentDTO;
import PRFT.developerProjectMongoDB.project_MongoDB.web.controller.AppointmentController;
import PRFT.developerProjectMongoDB.project_MongoDB.web.controller.userController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {
    private static String URL = "/api/v1/appointment";
    private static long ApptID = 10L;

    @Mock
    AppointmentRespository appointmentRespository;

    @Mock
    AppointmentService appointmentService;

    @Mock
    UserService service;

    @Mock
    UserRepository repository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    AppointmentController appointmentController;
    @InjectMocks
    userController controller;



    AppointmentDTO getValidAppt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        return AppointmentDTO.builder()
                .appointmentID(10L)
                .userEmail("Sid@gmail.com")
                .appointmentName("Dental")
                .appointmentType("1 HOUR")
                .appointmentDescription("Desc1")
                .appointmentDate(LocalDate.parse("2000-11-11",formatter))
                .startTime(LocalDateTime.parse("2000-11-11 11:11:11",formatter2))
                .endTime(LocalDateTime.parse("2000-11-11 11:11:11",formatter2))
                .metaData(null)
                .isDeleted(false)
                .build();
    }

    User getValidUser() {
        return User.builder()
                .userID(10L)
                .firstName("")
                .lastName("Dental")
                .gender("1 HOUR")
                .age("Desc1")
                .emailID("Sid@gmail.com")
                .phoneNumber("9AM")
                .build();
    }

    List<AppointmentDTO> getValidApptList() {
        List<AppointmentDTO> apptsList = new ArrayList<>();
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

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAppointment() {
        this.controller.createUser(getValidUser());
        AppointmentDTO newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
    }

    @Test
    void getAllAppointments_Success() throws Exception {
        List<AppointmentDTO> appointmentsList = new ArrayList<>();
        given(appointmentRespository.findAll()).willReturn(appointmentsList);
        ResponseEntity returnedAppointments = appointmentController.getAllAppointments();
        then(appointmentRespository).should().findAll();
        assertThat(returnedAppointments).isNotNull();
    }

    @Test
    void getAppointment() {
        this.controller.createUser(getValidUser());
        AppointmentDTO newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
    }

    @Test
    void deleteAppointment() {
        this.controller.createUser(getValidUser());
        AppointmentDTO newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
        Long newID = newAppt.getAppointmentID();
        appointmentController.deleteAppointment(10L);
        assertThat(appointmentService.isEmpty());
    }

    @Test
    void updateAppointment() {
        this.controller.createUser(getValidUser());
        this.appointmentController.createAppointment((getValidAppt()));
        Long newID = getValidAppt().getAppointmentID();
        assertThat(appointmentController.updateAppointment(newID, getValidAppt())).isNotNull();
    }
}