package com.example.classroomapi.Controllers;

import com.example.classroomapi.models.Docent;
import com.example.classroomapi.services.ServiceDocent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docent")
public class DocentControllers {

     @Autowired
     ServiceDocent service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Docent datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.savedocent(datosqueenviaelcliente));
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
