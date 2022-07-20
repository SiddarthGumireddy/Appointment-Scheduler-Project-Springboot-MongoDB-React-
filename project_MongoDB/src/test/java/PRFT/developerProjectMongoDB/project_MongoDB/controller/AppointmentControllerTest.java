package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.AppointmentRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {
    private static String URL = "/api/v1/appointment";
    private static long ApptID = 10L;

    @Mock
    AppointmentRespository appointmentRespository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    AppointmentController appointmentController;



    Appointment getValidAppt() {
        return Appointment.builder()
                .appointmentID(10L)
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

    List<Appointment> getValidApptList() {
        List<Appointment> apptsList = new ArrayList<>();
        apptsList.add(getValidAppt());
        apptsList.add(getValidAppt());
        return apptsList;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void createAppointment() {
        Appointment newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
    }

    @Test
    void getAllAppointments_Success() throws Exception {
        List<Appointment> appointmentsList = new ArrayList<>();
        given(appointmentRespository.findAll()).willReturn(appointmentsList);
        ResponseEntity returnedAppointments = appointmentController.getAllAppointments();
        then(appointmentRespository).should().findAll();
        assertThat(returnedAppointments).isNotNull();

    }

    @Test
    void getAppointment() {
        Appointment newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
    }

    @Test
    void deleteAppointment() {
        Appointment newAppt = getValidAppt();
        appointmentController.createAppointment(newAppt);
        assertThat(appointmentController.getAppointment(10L).equals(newAppt));
        Long newID = newAppt.getAppointmentID();
        appointmentController.deleteAppointment(10L);
        assertThat(appointmentRespository.isEmpty());
    }

    @Test
    void updateAppointment() {
    }
}