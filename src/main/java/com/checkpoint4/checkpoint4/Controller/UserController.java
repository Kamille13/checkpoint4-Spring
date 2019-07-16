package com.checkpoint4.checkpoint4.Controller;

import com.checkpoint4.checkpoint4.model.FreakShow;
import com.checkpoint4.checkpoint4.model.User;
import com.checkpoint4.checkpoint4.repository.FreakShowRepository;
import com.checkpoint4.checkpoint4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FreakShowRepository freakShowRepository;

    @GetMapping("/users")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/users/signIn")
    public User signIn(@RequestBody User user) {
        return userRepository.findUserByEmailIgnoreCase(user.getEmail());
    }

    @PostMapping("/users/{idUser}/freakshows/{idFreakShow}")
    public User addFavorite(@PathVariable Long idUser,
                            @PathVariable Long idFreakShow) {
        User user = userRepository.findById(idUser).get();
        FreakShow freakShow = freakShowRepository.findById(idFreakShow).get();
        user.getFreakshows().add(freakShow);
        freakShow.getUsers().add(user);
        freakShowRepository.save(freakShow);
        return userRepository.save(user);
    }
}
