package PRFT.developerProjectMongoDB.project_MongoDB.controller;

import PRFT.developerProjectMongoDB.project_MongoDB.Repositories.UserRepository;
import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3001")
public class userController {
    @Autowired
    private UserRepository repository;
    @PostMapping("/addUser")
//Add an Appointment to the DB
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if(user.getUserID()==null){
            user.setUserID(repository.generateLong());
        }
        User save = repository.save(user);
        if(save == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(save);
    }
    @GetMapping("/ListAllUsers")
    public ResponseEntity<?>ListUsers(){
        if(this.repository.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(this.repository.findAll());
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){

        if (this.repository.UUIDExists(id)) {
            Optional<User> user = repository.findById(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserByEId/{id}")
    public ResponseEntity<?> getUserByEId(@PathVariable String id){
        if (this.repository.userExists(id)) {
            User user = repository.findByEmail(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        if (this.repository.UUIDExists(id)) {
            repository.deleteById(id);
            return "User with UserID:" + id + " has been deleted!";
        }
        return "Invalid User ID, Please Try Again!";
    }
    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable() Long id,@RequestBody User user) {
        if (repository.UUIDExists(id)) {
            repository.deleteById(id);
            User save = repository.save(user);
            return ResponseEntity.ok(save);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
