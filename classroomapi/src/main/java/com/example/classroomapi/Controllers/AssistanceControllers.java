package com.example.classroomapi.Controllers;

import com.example.classroomapi.models.Assistance;
import com.example.classroomapi.services.ServiceAssistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistance")
public class AssistanceControllers {

    @Autowired
    ServiceAssistance service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Assistance datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveAssistence(datosqueenviaelcliente));
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
