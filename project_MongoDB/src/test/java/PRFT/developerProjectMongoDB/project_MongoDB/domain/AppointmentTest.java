package PRFT.developerProjectMongoDB.project_MongoDB.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void getAppointmentID() {
        Appointment appt = new Appointment();
        appt.setAppointmentID(10L);
        assertEquals(10L, appt.getAppointmentID());
    }

    @Test
    void getUserEmail() {
        Appointment appt = new Appointment();
        appt.setUserEmail("Peter");
        assertEquals("Peter", appt.getUserEmail());
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
    void getAppointmentDate() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String nowTime = "2011-11-11";
        LocalDate dateNew = LocalDate.parse(nowTime, formatter);
        appt.setStartTime(String.valueOf(dateNew));
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void getStartTime() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String nowTime = "2011-11-11 12:12:12";
        LocalDateTime dateNew = LocalDateTime.parse(nowTime, formatter);
        appt.setStartTime(nowTime);
        nowTime =  nowTime.replace("T"," ");
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void getEndTime() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String nowTime = "2011-11-11 12:12:12";
        LocalDateTime dateNew = LocalDateTime.parse(nowTime, formatter);
        appt.setEndTime(((nowTime)));
        nowTime =  nowTime.replace("T"," ");
        assertEquals(nowTime, appt.getEndTime());
    }

    @Test
    void getMetaData() {
        Appointment appt = new Appointment();
        appt.setMetaData(null);
        assertNull(appt.getMetaData());
    }

    @Test
    void getIsDeleted() {
        Appointment appt = new Appointment();
        appt.setIsDeleted(true);
        assertEquals(true, appt.getIsDeleted());
    }

    @Test
    void setAppointmentID() {
        Appointment appt = new Appointment();
        appt.setAppointmentID(10L);
        assertEquals(10L, appt.getAppointmentID());
    }

    @Test
    void setUserEmail() {
        Appointment appt = new Appointment();
        appt.setUserEmail("Peter");
        assertEquals("Peter", appt.getUserEmail());
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
    void setAppointmentDate() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String nowTime = "2011-11-11";
        LocalDate dateNew = LocalDate.parse(nowTime, formatter);
        appt.setStartTime(String.valueOf(dateNew));
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void setStartTime() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String nowTime = "2011-11-11 12:12:12";
        LocalDateTime dateNew = LocalDateTime.parse(nowTime, formatter);
        appt.setStartTime(nowTime);
        nowTime =  nowTime.replace("T"," ");
        assertEquals(nowTime, appt.getStartTime());
    }

    @Test
    void setEndTime() {
        Appointment appt = new Appointment();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String nowTime = "2011-11-11 12:12:12";
        LocalDateTime dateNew = LocalDateTime.parse(nowTime, formatter);
        appt.setEndTime(nowTime);
        nowTime =  nowTime.replace("T"," ");
        assertEquals(nowTime, appt.getEndTime());
    }

    @Test
    void setMetaData() {
        Appointment appt = new Appointment();
        appt.setMetaData(null);
        assertNull(appt.getMetaData());
    }

    @Test
    void setIsDeleted() {
        Appointment appt = new Appointment();
        appt.setIsDeleted(true);
        assertEquals(true, appt.getIsDeleted());
    }

    @Test
    void testEquals() {
        Appointment ap1 = new Appointment();
        Appointment ap2 = new Appointment();
        ap2.setAppointmentName("None");
        ap1 = ap2;
        assertThat(ap1.equals(ap2)).isEqualTo(true);

    }
    @Test
    void testToString() {
        Appointment ap1 = new Appointment();
        ap1.setAppointmentID(Long.valueOf(123456));
        assertThat(ap1.getAppointmentID().toString()).isEqualTo("123456");
    }

    @Test
    void builder() {
    }
}