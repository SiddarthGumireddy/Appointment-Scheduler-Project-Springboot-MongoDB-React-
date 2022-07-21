package PRFT.developerProjectMongoDB.project_MongoDB.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {
    @Id
    private Long userID;
    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String emailID;
    private String phoneNumber;
}
