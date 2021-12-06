package com.cesarsanchezbackend.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cesarsanchezbackend.app.entitiy.User;
import com.cesarsanchezbackend.app.service.UserService;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mascota")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="id") Long id) {
        Optional<User> oUser = userService.findById(id);

        if(!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value="id") Long userId) {
        Optional<User> user = userService.findById(userId);

        if(!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(userDetails, user.get());
        user.get().setIdDuenio(userDetails.getIdDuenio());
        user.get().setIdTipoMascota(userDetails.getIdTipoMascota());
        user.get().setNombre(userDetails.getNombre());
        user.get().setFechaIngreso(userDetails.getFechaIngreso());
        user.get().setMotivoIngreso(userDetails.getMotivoIngreso());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    
    }

    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long userId) {
        
        if(!userService.findById(userId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //Read all users
    @GetMapping
    public List<User> readAll() {
        
        List<User> users = StreamSupport
            .stream(userService.findAll().spliterator(), false)
            .collect(Collectors.toList());
        
        return users;

    }


}
