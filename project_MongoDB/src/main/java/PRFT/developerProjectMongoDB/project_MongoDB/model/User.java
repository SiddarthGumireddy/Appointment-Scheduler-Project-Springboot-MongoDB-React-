package PRFT.developerProjectMongoDB.project_MongoDB.model;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.EmailAddress;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
