package PRFT.developerProjectMongoDB.project_MongoDB.domain;

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
import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Appointments")
public class Appointment {
    @Id
    private Long appointmentID;
    private String userEmail;
    private String appointmentName;
    private String appointmentType;
    private String appointmentDescription;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String appointmentDate;
    private String startTime;
    private String endTime;
    private Object metaData;
    private Boolean isDeleted;




}
