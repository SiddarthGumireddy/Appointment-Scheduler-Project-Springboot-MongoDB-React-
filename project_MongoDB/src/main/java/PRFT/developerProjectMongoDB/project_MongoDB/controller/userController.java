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
public class userController {
    @Autowired
    private UserRepository repository;
    @PostMapping("/addUser")
    //Add an Appointment to the DB
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User save = this.repository.save(user);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/ListAllUsers")
    public List<User>ListUsers(){
        return this.repository.findAll();
    }
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable UUID id){
        return repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id){
        repository.deleteById(id);
        return "User with UserID:" + id +" has been deleted!";
    }

//    public userController(UserServices userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping({"/{userID"})
//    public ResponseEntity<user> getUser(@PathVariable("customerId")  UUID userId){
//
//        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
//    }
}
