package PRFT.developerProjectMongoDB.project_MongoDB.model;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.EmailAddress;
import PRFT.developerProjectMongoDB.project_MongoDB.domain.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long userID;
    private String firstName;
    private String lastName;

    private String gender;

    private String age;

    private String emailID;
    private String phoneNumber;
}
