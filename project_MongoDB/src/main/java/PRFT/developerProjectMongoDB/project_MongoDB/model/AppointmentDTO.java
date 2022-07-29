package PRFT.developerProjectMongoDB.project_MongoDB.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate appointmentDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private Object metaData;
    private Boolean isDeleted;

}
