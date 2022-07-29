package PRFT.developerProjectMongoDB.project_MongoDB.Services;

import PRFT.developerProjectMongoDB.project_MongoDB.domain.User;


public interface UserService {

    Boolean isEmpty();

    Boolean userExists(String emailID);

    void deleteUserAppointments(String emailID);
    User findByUserID(Long id);
    String getEmailfromID(Long id);
    Long generateLong();


    boolean UUIDExists(Long id);

    User findByEmail(String id);
}
