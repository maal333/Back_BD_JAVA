package com.example.classroomapi.services;


import com.example.classroomapi.models.Qualifications;
import com.example.classroomapi.models.Registration;
import com.example.classroomapi.repositorios.IQualificationsRepository;
import com.example.classroomapi.repositorios.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRegistration {

    @Autowired
    IRegistrationRepository repository;

    public Registration saveRegsitration (Registration dataRegistration) throws Exception{

        try {
            return  this.repository.save(dataRegistration);
        }catch (Exception error) {
            throw new Exception();

        }
    }

    //metodo para guardarTodo
    public List<Registration> registrationList () throws  Exception{

        try{
            return  this.repository.findAll();
        }catch (Exception error){
            throw  new Exception();
        }

    }
}
