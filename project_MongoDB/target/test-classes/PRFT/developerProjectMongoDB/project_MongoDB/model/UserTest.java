package PRFT.developerProjectMongoDB.project_MongoDB.model;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUserById() {
        User user = new User();
        user.setUserID(893472);
        assertEquals(893472, user.getUserID());
    }


    @Test
    void getUserEmail() {
        User user = new User();
        user.setUserEmail("Jakes@gmail.com");
        assertEquals("Jakes@gmail.com", user.getUserEmail());
    }

    @Test
    void getUserFirstName() {
        User user = new User();
        user.setFirstName("Jack");
        assertEquals("Jack", user.getUserFirstName());
    }

    @Test
    void getUserLastName() {
        User user = new User();
        user.setLastName("Black");
        assertEquals("Black", user.getLastName());
    }

    @Test
    void getUserEmail() {
        User user = new User();
        user.setUserEmail("JackBlck@gmail.com");
        assertEquals("JackBlck@gmail.com", user.getUserEmail());
    }

    @Test
    void getUserGender() {
        User user = new User();
        user.setUserGender("Male");
        assertEquals("Male", user.getUserGender());
    }

    @Test
    void getUserFirstName() {
        User user = new User();
        user.setUserFirstName("Jackie");
        assertEquals("Jackie", user.getUserFirstName());
    }

    @Test
    void getUserPhoneNumber() {
        User user = new User();
        user.setUserLastName("2341342342");
        assertEquals(2341342342, user.getUserPhoneNumber());
    }

    @Test
    void getAge() {
        User user = new User();
        user.setAge(null);
        assertNull(user.getAge());
    }

    @Test
    void setUserID() {
        User user = new User();
        user.setUserID(893472);
        assertEquals(893472, user.getUserID());
    }

    @Test
    void setUserEmail() {
        User user = new User();
        user.setUserEmail("GumBear@gmail.com");
        assertEquals("GumBear@gmail.com", user.getUserEmail());
    }

    @Test
    void setUserLastName() {
        User user = new User();
        user.setUserLastName("JJO");
        assertEquals("JJO", user.getUserLastName());
    }

    @Test
    void setUserGender() {
        User user = new User();
        user.setUserGender("Female");
        assertEquals("Female", user.getUserGender());
    }

    @Test
    void setUserGender() {
        User user = new User();
        user.setUserGender("M");
        assertEquals("M", user.getUserGender());
    }

    @Test
    void setUserFirstName() {
        User user = new User();
        user.setUserFirstName("John");
        assertEquals("John", user.getUserFirstName());
    }

    @Test
    void setUserLastName() {
        User user = new User();
        user.setUserLastName("Smith");
        assertEquals("Smith", user.getUserLastName());
    }

    @Test
    void setPhoneNumber() {
        User user = new User();
        user.setPhoneNumber(null);
        assertNull(user.getUserPhoneNumber());
    }
@Test
    void getUserEmail(){
        User user=new User();
        user.setUserEmail("JohnSmith@gmail.com");
        assertEquals("JohnSmith@gmail.com",user.getUserEmail());
    }

@Test
    void getUserFirstName(){
        User user=new User();
        user.setUserFirstName("Peter");
        assertEquals("Peter",user.getUserFirstName());
    }

@Test
    void getUserGender(){
        User user=new User();
        user.setUserGender("MALE");
        assertEquals("MALE",user.getUserGender());
            }

@Test
     void getUserGender(){
        User user=new User();
        user.setUserGender(null);
        assertNull(user.getUserGender());
             }

@Test
    void getUserFirstName(){
        User user=new User();
        user.setUserFirstName(null);
        assertNull(user.getUserFirstName());
            }

@Test
    void getUserPhoneNumber(){
        User user=new User();
        user.setUserPhoneNumber("8907654321");
        assertEquals(8907654321,user.getUserPhoneNumber());
            }

@Test
    void getAge(){
        User user=new User();
        user.setAge(null);
        assertNull(user.getAge());
                    }

@Test
    void setUserID(){
        User user=new User();
        user.setUserID(1089242);
        assertEquals(1089242,user.getUserID());
                    }

@Test
    void setUserEmail(){
        User user=new User();
        user.setUserEmail("Peter");
        assertEquals("Peter",user.getUserEmail());
                    }

@Test
    void setUserName(){
        User user=new User();
        user.setUserName("Dental");
        assertEquals("Dental",user.getUserName());
                    }

@Test
    void setUserGender(){
        User user=new User();
        user.setUserGender(null);
        assertNull(user.getUserGender());
    }

@Test
    void setUserID(){
        User user=new User();
        user.setUserID(123413);
        assertEquals(123413,user.getUserID());
}

@Test
    void setUserFirstName(){
        User user=new User();
        user.setUserFirstName("James");
        assertEquals("James",user.getUserFirstName());
}

@Test
    void setUserLastName(){
        User user=new User();
        user.setUserLastName("Clark");
        assertEquals("Clark",user.getUserPhoneNumber());
    }

@Test
    void setAge(){
        User user=new User();
        user.setAge("32");
        assertEquals("32",user.getAge());
}

@Test
    void getUserEmail(){
        User user=new User();
        user.setUserEmail("ParkerP@gmail.com");
        assertEquals("ParkerP@gmail.com",user.getUserEmail());
    }

@Test
    void getUserPhoneNumber(){
        User user=new User();
        user.setPhoneNumber("234234234");
        assertEquals("234234234",user.getUserPhoneNumber());
            }

@Test
    void getUserGender(){
        User user=new User();
        user.setUserGender("Male");
        assertEquals("Male",user.getUserGender());
            }

@Test
    void getUserGender(){
            User user=new User();
            user.setUserGender("FEM");
            assertEquals("FEM",user.getUserGender());
            }

@Test
    void getUserFirstName(){
            User user=new User();
            user.setUserFirstName("Dane");
            assertEquals("Dane",user.getUserFirstName());
            }

@Test
    void getUserPhoneNumber(){
            User user=new User();
            String phone="9992139231";
            user.setPhoneNumber(phone);
            assertEquals(phone,user.getUserPhoneNumber());
            }

@Test
    void getAge(){
            User user=new User();
            user.setAge(null);
            assertNull(user.getAge());
            }

@Test
    void setUserID(){
            User user=new User();
            user.setUserID(100000);
            assertEquals(100000,user.getUserID());
            }

@Test
    void setUserEmail(){
            User user=new User();
            user.setUserEmail("WhoAmI@yahoo.com");
            assertEquals("WhoAmI@yahoo.com",user.getUserEmail());
            }

@Test
    void setPhoneNumber(){
            User user=new User();
            user.setPhoneNumber("349082314");
            assertEquals("349082314",user.getUserPhoneNumber());
            }

@Test
    void setUserGender(){
            User user=new User();
            user.setUserGender("Female");
            assertEquals("Female",user.getUserGender());
            }

@Test
    void setUserGender(){
            User user=new User();
            user.setUserGender("F");
            assertEquals("F",user.getUserGender());
            }

@Test
    void setUserFirstName(){
            User user=new User();
            user.setUserFirstName("William");
            assertEquals("William",user.getUserFirstName());
            }

@Test
    void setUserLastName(){
            User user=new User();
            user.setUserLastName("Cena");
            assertEquals("Cena",user.getUserLastName());
            }

@Test
    void setAge(){
            User user=new User();
            user.setAge("22");
            assertEquals("22",user.getAge());
            }

            }