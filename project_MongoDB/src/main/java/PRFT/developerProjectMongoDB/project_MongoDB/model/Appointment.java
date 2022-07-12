package PRFT.developerProjectMongoDB.project_MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Appointments")
public class Appointment {
    private UUID appointmentID;
    private UUID userID;
    private String appointmentName;
    private String appointmentType;
    private String appointmentDescription;
    private String startTime;
    private String endTime;
    private String metaData;



}
