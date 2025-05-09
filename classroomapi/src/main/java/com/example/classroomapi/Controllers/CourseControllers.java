package com.example.classroomapi.Controllers;

import com.example.classroomapi.models.Course;
import com.example.classroomapi.services.ServiceCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseControllers {

    @Autowired
    ServiceCourse service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Course datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveCourse(datosqueenviaelcliente));
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
