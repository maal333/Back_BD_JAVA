package com.example.classroomapi.Controllers;


import com.example.classroomapi.models.Subject;
import com.example.classroomapi.services.ServiceSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectControllers {

    @Autowired
    ServiceSubject service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Subject datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveSubject(datosqueenviaelcliente));
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
