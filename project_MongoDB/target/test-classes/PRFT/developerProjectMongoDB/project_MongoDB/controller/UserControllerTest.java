package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRespository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
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
class UserControllerTest {
    private static String URL = "/api/v1/user";
    private static long ApptID = 893472;

    @Mock
    UserRespository userRespository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    UserController userController;



    User getValidAppt() {
        return User.builder()
                .userID(893472)
                .emailID("JsMith@gmail.com")
                .firstName("Jake")
                .lastName("Smith")
                .age("22")
                .gender("Male")
                .phoneNumber("2345432453")
                .build();
    }

    List<User> getValidUserList() {
        List<User> usersList = new ArrayList<>();
        usersList.add(getValidUserList());
        usersList.add(getValidUserList());
        return apptsList;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void createUser() {
        User newUser = getValidUserList();
        userController.createUser(newUser);
        assertThat(userController.getUserById(893472).equals(newUser));
    }

    @Test
    void ListUsers_Success() throws Exception {
        List<User> userList = new ArrayList<>();
        given(userRespository.findAll()).willReturn(userList);
        ResponseEntity returnedUsers = userController.ListUsers();
        then(userRespository).should().findAll();
        assertThat(returnedUsers).isNotNull();

    }

    @Test
    void getUserById() {
        User newUser = getValidUserList();
        userController.createUser(newUser);
        assertThat(userController.getUserById(893472).equals(newUser));
    }
    @Test
    void getUserByEId() {
        User newUser = getValidUserList();
        userController.createUser(newUser);
        assertThat(userController.getUserByEId("JsMith@gmail.com").equals(newUser));
    }

    @Test
    void deleteUser() {
        User newUser = getValidUserList();
        userController.createUser(newUser);
        assertThat(userController.getUserById(893472).equals(newUser));
        Long newUserID = newUser.getUserID();
        userController.delete(893472);
        assertThat(userRespository.isEmpty());
    }

    @Test
    void updateUser() {
    }
}