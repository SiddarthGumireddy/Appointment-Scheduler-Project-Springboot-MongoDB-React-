package PRFT.developerProjectMongoDB.project_MongoDB.model;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getByUserID() {
        User user = new User();
        user.setUserID(Long.valueOf(893472));
        assertEquals(Long.valueOf(893472), user.getUserID());
    }


    @Test
    void getEmailID() {
        User user = new User();
        user.setEmailID("Jakes@gmail.com");
        assertEquals("Jakes@gmail.com", user.getEmailID());
    }

    @Test
    void getFirstName() {
        User user = new User();
        user.setFirstName("Jack");
        assertEquals("Jack", user.getFirstName());
    }

    @Test
    void getLastName() {
        User user = new User();
        user.setLastName("Black");
        assertEquals("Black", user.getLastName());
    }


    @Test
    void getGender() {
        User user = new User();
        user.setGender("Male");
        assertEquals("Male", user.getGender());
    }


    @Test
    void getPhoneNumber() {
        User user = new User();
        user.setPhoneNumber("2341342342");
        assertEquals("2341342342", user.getPhoneNumber());
    }

    @Test
    void getAge() {
        User user = new User();
        user.setAge(null);
        assertNull(user.getAge());
    }
    @Test
    void setAge() {
        User user = new User();
        user.setAge("21");
        assertEquals("21",user.getAge());
    }
    @Test
    void setUserID() {
        User user = new User();
        user.setUserID(Long.valueOf(893472));
        assertEquals(Long.valueOf(893472), user.getUserID());
    }

    @Test
    void setEmailID() {
        User user = new User();
        user.setEmailID("GumBear@gmail.com");
        assertEquals("GumBear@gmail.com", user.getEmailID());
    }


    @Test
    void setGender() {
        User user = new User();
        user.setGender("Female");
        assertEquals("Female", user.getGender());
    }


    @Test
    void setFirstName() {
        User user = new User();
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }

    @Test
    void setLastName() {
        User user = new User();
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    void setPhoneNumber() {
        User user = new User();
        user.setPhoneNumber(null);
        assertNull(user.getPhoneNumber());
    }








}