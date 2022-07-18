package PRFT.developerProjectMongoDB.project_MongoDB.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Appointments")
public class Appointment {
    @Id
    private Long appointmentID;
    private Long userID;
    private String userName;
    private String appointmentName;
    private String appointmentType;
    private String appointmentDescription;
    private Timestamp startTime;
    private Timestamp endTime;
    private Object metaData;



}
