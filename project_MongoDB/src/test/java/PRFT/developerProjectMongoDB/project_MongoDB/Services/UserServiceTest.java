package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.web.controller.AppointmentController;
import PRFT.developerProjectMongoDB.project_MongoDB.web.controller.userController;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
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
class UserServiceTest {
    private static String URL = "/api/v1/user";
    private static long ApptID = 10L;

    @Mock
    AppointmentService service;

    @Mock
    UserRepository repository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    AppointmentController appointmentController;
    @InjectMocks
    userController controller;

    Long newID = Long.valueOf(821159);

    User getValidUser() {
        return User.builder()
                .userID(10L)
                .firstName("Buckky")
                .lastName("Churro")
                .gender("Male")
                .age("25")
                .emailID("BuckkyCH@gmail.com")
                .phoneNumber("235-254-2342")
                .isDeleted(false)
                .build();
    }

    @Test
    void generateLong(){
        Long gen = this.service.generateLong();
        Boolean trial1 = this.service.UUIDExists(gen);
        Boolean trial2 = false;
        assertThat(trial1).isEqualTo(trial2);
    }

    @Test
    void UUIDExists(){
        Boolean trial1 = false;
        Boolean trial2 = this.service.UUIDExists(getValidUser().getUserID());
        assertThat(trial1).isEqualTo(trial2);
    }


//    @Test
//    void testIsEmpty() {
//        this.controller.createUser(getValidUser());
//        assertThat(this.service.isEmpty()).isEqualTo(false);
//    }

    @Test
    void testUUIDExists() {
        Boolean trial = false;
        Boolean trial2 = this.service.UUIDExists(getValidUser().getUserID());
        assertThat(trial).isEqualTo(trial2);
    }

    @Test
   void testFindByEmail(){
        String emailEntry="BuckkyCH@gmail.com";
        assertThat(emailEntry).isEqualTo("BuckkyCH@gmail.com");
    }
    @Test
    void testGetEmailById(){
    }

    @BeforeEach
    void setUp() {
    }
}