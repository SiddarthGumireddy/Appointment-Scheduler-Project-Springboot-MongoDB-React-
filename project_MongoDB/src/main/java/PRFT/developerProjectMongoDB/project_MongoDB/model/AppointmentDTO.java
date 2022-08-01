package PRFT.developerProjectMongoDB.project_MongoDB.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AppointmentDTO implements Serializable {
    @Id
    private Long appointmentID;
    @NotBlank
    private String userEmail;
    @NotBlank
    private String appointmentName;
    @NotBlank
    private String appointmentType;
    private String appointmentDescription;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String appointmentDate;

    private String startTime;
    private String endTime;
    private Object metaData;
    private Boolean isDeleted;

}
