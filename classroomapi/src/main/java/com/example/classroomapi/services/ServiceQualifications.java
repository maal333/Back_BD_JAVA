package com.example.classroomapi.services;

import com.example.classroomapi.models.Qualifications;
import com.example.classroomapi.repositorios.IQualificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceQualifications {

    @Autowired
    IQualificationsRepository repository;

    public Qualifications saveQualification (Qualifications dataQualification) throws Exception{

        try {
            return  this.repository.save(dataQualification);



        }catch (Exception error) {
            throw new Exception();

        }
    }


    //metodo par buscarTodo
    public List<Qualifications> qualificationsList() throws  Exception{

        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception();
        }
    }



}
