package fr.simplon.orgamenu.controllers;


import fr.simplon.orgamenu.exceptions.UserNotFoundExceptions;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("username/{username}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<User> getByUsername(@PathVariable String username) throws UserNotFoundExceptions {
        System.out.println("--------------");
        System.out.println(username);
        System.out.println("--------------");
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            System.out.println(user);
            return user;
        }
        throw new UserNotFoundExceptions();
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<User> getUserById(@PathVariable int id) throws UserNotFoundExceptions {
        System.out.println(id + "usercontroller");
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            System.out.println(user);
            return user;
        }
        throw new UserNotFoundExceptions();
    }
}

