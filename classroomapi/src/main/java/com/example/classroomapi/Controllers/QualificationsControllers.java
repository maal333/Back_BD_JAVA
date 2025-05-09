package com.example.classroomapi.Controllers;


import com.example.classroomapi.models.Qualifications;
import com.example.classroomapi.services.ServiceQualifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Qualifications")
public class QualificationsControllers {

    @Autowired
    ServiceQualifications service;


    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Qualifications datosqueenviaelcliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveQualification(datosqueenviaelcliente));
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
