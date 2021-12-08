package veterinaria.demo.Controller;

import veterinaria.demo.Service.CitaService;
import veterinaria.demo.model.Cita;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cita user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="idCita") Long idCita) {
        Optional<Cita> oUser = userService.findById(idCita);

        if(!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cita userDetails, @PathVariable(value="idCita") Long idCita) {
        Optional<Cita> user = userService.findById(idCita);

        if(!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(userDetails, user.get());
        user.get().setIdCita(userDetails.getIdCita());
        user.get().setFechaCita(userDetails.getFechaCita());
        user.get().setHoraCita(userDetails.getHoraCita());
        user.get().setIdDuenio(userDetails.getIdDuenio());
        user.get().setServicio(userDetails.getServicio());
        

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
    public List<Cita> readAll() {
        
        List<Cita> users = StreamSupport
            .stream(userService.findAll().spliterator(), false)
            .collect(Collectors.toList());
        
        return users;

    }


}
