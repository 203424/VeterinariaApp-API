package clasefonbon.BD203426.controller;

import clasefonbon.BD203426.model.Duenio;

import clasefonbon.BD203426.service.DueniosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/duenio")
@CrossOrigin
public class DuenioController {

    @Autowired
    private DueniosService dueniosService;

    @PostMapping("/add")
    public String add(@RequestBody Duenio duenio){
        dueniosService.saveDuenio(duenio);
        return "Duenio Added";
    
    }
    
    @GetMapping(value = "/getAll")
    public List<Duenio> getAllDuenios(){
        List<Duenio> res = dueniosService.getAllDuenios();
        if(res==null){
            return null;
        }else{
            return res;
        }
    }


    @DeleteMapping(value = "/del/{id}")
    public String borrarDuenio(@PathVariable(value="id") Integer id){
        dueniosService.eliminar(id);
        return "Dueño borrado";
    
    }

    @PutMapping(value = "/updateNum")
    public String actualizarNum(@RequestBody Duenio duenio){
        dueniosService.updateNum(duenio);
        return"Todo nice";
    }

    @PutMapping(value = "/updateDirec")
    public String actualizarDirec(@RequestBody Duenio duenio){
        dueniosService.updateNum(duenio);
        return"Todo nice";
    }
    //Delete an user
   


    /*@GetMapping(value = "/ListDueños")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Duenio> getDuenios(){
        List<Duenio> res = duenioRepository.findAll();
        if(res==null){
            return null;
        }else{
            return res;
        }
    }

    @PostMapping(value = "/duenioId")
    public Duenio getDuenioId(@RequestBody Duenio duenio){
        return duenioRepository.findByIdDuenio(duenio.getIdDuenio());
    }
    @PostMapping(value = "/duenioCantMascotas")
    public Duenio getDuenioCant(@RequestBody Duenio duenio){
        return duenioRepository.findByCantMascotas(duenio.getCantMascotas());
    }
    @PostMapping(value = "/duenioNombre")
    public Duenio getDuenioNombre(@RequestBody Duenio duenio){
        return duenioRepository.findByNombreDuenio(duenio.getNombreDuenio());
    }
    @PostMapping(value = "/duenioDirec")
    public Duenio getDuenioDirec(@RequestBody Duenio duenio){
        return duenioRepository.findByDireccion(duenio.getDireccion());
    }
    @PostMapping(value = "/duenioNum")
    public Duenio getDuenioNum(@RequestBody Duenio duenio){
        return duenioRepository.findByNumTelefono(duenio.getNumTelefono());
    }
    @PostMapping(value = "/agregarDuenio", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Duenio addCustomer(@RequestBody Duenio duenio){

        return duenioRepository.save(duenio);
    }*/

}
