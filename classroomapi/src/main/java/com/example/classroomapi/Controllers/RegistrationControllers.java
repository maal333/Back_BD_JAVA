package com.example.classroomapi.Controllers;


import com.example.classroomapi.models.Registration;
import com.example.classroomapi.services.ServiceRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationControllers {

    @Autowired
    ServiceRegistration service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Registration datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveRegsitration(datosqueenviaelcliente));
        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //buscartodos



    //buscarporId

    //modificar

    //eliminar


}
