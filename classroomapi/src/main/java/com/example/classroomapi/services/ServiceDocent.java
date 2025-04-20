package com.example.classroomapi.services;

import com.example.classroomapi.models.Docent;
import com.example.classroomapi.repositorios.IDocentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDocent {

    @Autowired
    // llama al repositorio
    IDocentRepository repository;
    //nombre de como lo va a llamar

    // metodo para guardar
    public Docent savedocent(Docent datadocent)throws Exception{

        try{
            return this.repository.save(datadocent);

        }catch (Exception error){
         throw new Exception();
        }

    }


    // metodo para buscarTodo
public List<Docent> docentList() throws Exception{

        try{
            return  this.repository.findAll();

        }catch (Exception error) {
            throw new Exception();
        }
    }


    //metodo para buscarunoporID




    //metodo para modificar





    //metodo para eliminar






}
