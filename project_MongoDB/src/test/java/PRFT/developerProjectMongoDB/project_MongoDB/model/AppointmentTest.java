package PRFT.developerProjectMongoDB.project_MongoDB.model;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void getAppointmentID() {
        Appointment appt = new Appointment();
        appt.setAppointmentID(10L);
        assertEquals(10L, appt.getAppointmentID());
    }

    @Test
    void getUserID() {
        Appointment appt = new Appointment();
        appt.setUserID(1L);
        assertEquals(1L, appt.getUserID());
    }

    @Test
    void getUserName() {
        Appointment appt = new Appointment();
        appt.setUserName("Peter");
        assertEquals("Peter", appt.getUserName());
    }

    @Test
    void getAppointmentName() {
        Appointment appt = new Appointment();
        appt.setAppointmentName("Dental");
        assertEquals("Dental", appt.getAppointmentName());
    }

    @Test
    void getAppointmentType() {
        Appointment appt = new Appointment();
        appt.setAppointmentType("1 hour");
        assertEquals("1 hour", appt.getAppointmentType());
    }

    @Test
    void getAppointmentDescription() {
        Appointment appt = new Appointment();
        appt.setAppointmentDescription("Desc1");
        assertEquals("Desc1", appt.getAppointmentDescription());
    }

    @Test
    void getStartTime() {
        Appointment appt = new Appointment();
        Timestamp nowTime = Timestamp.from(Instant.now());
        appt.setStartTime(nowTime);
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void getEndTime() {
        Appointment appt = new Appointment();
        Timestamp nowTime = Timestamp.from(Instant.now());
        appt.setEndTime(nowTime);
        assertEquals(nowTime, appt.getEndTime());
    }

    @Test
    void getMetaData() {
        Appointment appt = new Appointment();
        appt.setMetaData(null);
        assertNull(appt.getMetaData());
    }

    @Test
    void setAppointmentID() {
        Appointment appt = new Appointment();
        appt.setAppointmentID(10L);
        assertEquals(10L, appt.getAppointmentID());
    }

    @Test
    void setUserID() {
        Appointment appt = new Appointment();
        appt.setUserID(1L);
        assertEquals(1L, appt.getUserID());
    }

    @Test
    void setUserName() {
        Appointment appt = new Appointment();
        appt.setUserName("Peter");
        assertEquals("Peter", appt.getUserName());
    }

    @Test
    void setAppointmentName() {
        Appointment appt = new Appointment();
        appt.setAppointmentName("Dental");
        assertEquals("Dental", appt.getAppointmentName());
    }

    @Test
    void setAppointmentType() {
        Appointment appt = new Appointment();
        appt.setAppointmentType("1 hour");
        assertEquals("1 hour", appt.getAppointmentType());
    }

    @Test
    void setAppointmentDescription() {
        Appointment appt = new Appointment();
        appt.setAppointmentDescription("Desc1");
        assertEquals("Desc1", appt.getAppointmentDescription());
    }

    @Test
    void setStartTime() {
        Appointment appt = new Appointment();
        Timestamp nowTime = Timestamp.from(Instant.now());
        appt.setStartTime(nowTime);
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void setEndTime() {
        Appointment appt = new Appointment();
        Timestamp nowTime = Timestamp.from(Instant.now());
        appt.setEndTime(nowTime);
        assertEquals(nowTime, appt.getEndTime());
    }

    @Test
    void setMetaData() {
        Appointment appt = new Appointment();
        appt.setMetaData(null);
        assertNull(appt.getMetaData());
    }

}