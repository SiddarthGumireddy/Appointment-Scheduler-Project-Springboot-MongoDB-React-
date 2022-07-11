package PRFT.developerProjectMongoDB.project_MongoDB.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.UUID;

@Document(collection = "Appointments")
public class Appointment {
    private Integer appointmentID;
    private String appointmentName;

    public Appointment(Integer appointmentID, String appointmentName) {
        this.appointmentID = appointmentID;
        this.appointmentName = appointmentName;
    }

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }
}
