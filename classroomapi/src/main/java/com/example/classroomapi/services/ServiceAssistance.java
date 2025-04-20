package com.example.classroomapi.services;


import com.example.classroomapi.models.Assistance;
import com.example.classroomapi.repositorios.IAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAssistance {

    @Autowired

    IAssistanceRepository repository;

    public Assistance saveAssistence (Assistance dataAssistance) throws Exception{

        try{
            return this.repository.save(dataAssistance);

        }catch (Exception error){
            throw new Exception();
        }


    }

    // metodo paar buscarTodo
    public List<Assistance> assistanceList() throws Exception{


        try {
            return  this.repository.findAll();
        }catch (Exception error){
            throw new Exception();

        }

    }


}