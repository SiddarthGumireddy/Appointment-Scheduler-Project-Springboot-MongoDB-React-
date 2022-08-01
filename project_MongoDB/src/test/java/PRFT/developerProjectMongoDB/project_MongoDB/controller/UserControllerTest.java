package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.Services.UserService;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import PRFT.developerProjectMongoDB.project_MongoDB.web.controller.userController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private static String URL = "/api/v1/user";
    private static long UserID = 893472;

    @Mock
    UserService userService;
    @Mock
    UserRepository repository;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    PRFT.developerProjectMongoDB.project_MongoDB.web.controller.userController userController;



    User getValidUser() {
        return User.builder()
                .userID(UserID)
                .emailID("JsMith@gmail.com")
                .firstName("Jake")
                .lastName("Smith")
                .age("22")
                .gender("Male")
                .phoneNumber("2345432453")
                .build();
    }



    @BeforeEach
    void setUp() {

    }

    @Test
    void createUser() {
        User newUser = getValidUser();
        userController.createUser(newUser);
        assertThat(userController.getUserById(Long.valueOf(893472)).equals(newUser));
    }

    @Test
    void ListUsers_Success() throws Exception {
        List<User> userList = new ArrayList<>();
        given(repository.findAll()).willReturn(userList);
        ResponseEntity returnedUsers = userController.ListUsers();
        then(repository).should().findAll();
        assertThat(returnedUsers).isNotNull();

    }

    @Test
    void getUserById() {
        User newUser = getValidUser();
        userController.createUser(newUser);
        assertThat(userController.getUserById(UserID).equals(newUser));
    }
    @Test
    void getUserByEId() {
        User newUser = getValidUser();
        userController.createUser(newUser);
        assertThat(userController.getUserByEId("JsMith@gmail.com").equals(newUser));
    }

    @Test
    void deleteUser() {
        User newUser = getValidUser();
        userController.createUser(newUser);
        assertThat(userController.getUserById(UserID).equals(newUser));
        Long newUserID = newUser.getUserID();
        userController.deleteUser(UserID);
        assertThat(userService.isEmpty());
    }
    @Test
    void softDelete(){
        User newUser=getValidUser();
        userController.createUser(newUser);
        assertThat(userController.getUserById(UserID).equals(newUser));
        Long newUserID = newUser.getUserID();
        userController.softDeleteUser(UserID);
        assertThat(newUser.getIsDeleted());
    }

}