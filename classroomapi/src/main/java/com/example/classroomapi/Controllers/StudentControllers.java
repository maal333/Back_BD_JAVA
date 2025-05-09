package com.example.classroomapi.Controllers;


import com.example.classroomapi.models.Student;
import com.example.classroomapi.services.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentControllers {

    @Autowired
    ServiceStudent service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Student datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveStudent(datosqueenviaelcliente));
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
