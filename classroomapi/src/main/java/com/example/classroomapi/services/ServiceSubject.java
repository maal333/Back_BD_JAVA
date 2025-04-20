package com.example.classroomapi.services;


import com.example.classroomapi.models.Subject;
import com.example.classroomapi.repositorios.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSubject{

    @Autowired
    ISubjectRepository repository;

    public Subject saveSubject (Subject dataSubject) throws Exception{

        try {
            return  this.repository.save(dataSubject);
        }catch (Exception error) {
            throw new Exception();

        }
    }

    //metodo para buscarTodo
    public List<Subject>  subjectList()throws  Exception{
        try{
            return  this.repository.findAll();
        }catch (Exception error){
            throw new Exception();
        }

    }


}
