package com.example.classroomapi.services;


import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.models.Subject;
import com.example.classroomapi.repositorios.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //metodo para buscarunoporID
    public Subject searchsubjectbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Subject> subjectImlookingfor=this.repository.findById(id);
            if (subjectImlookingfor.isPresent()){
                return subjectImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_SUBJECT_NOT_FOUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }


    //metodo para modificar

    public Subject modifysubject(Integer id, Subject datosnuevosasigantura)throws Exception{

        try{
            Optional<Subject> subjectImlookingfortoedit  =this.repository.findById(id);

            if (subjectImlookingfortoedit.isPresent()){

                //modificar docente
                subjectImlookingfortoedit.get().setName_Subject(datosnuevosasigantura.getName_Subject());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(subjectImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }


    //metodo para eliminar

    public boolean deletesubject(Integer id)throws  Exception {

        try {
            Optional<Subject> subjectsearch = this.repository.findById(id);
            if (subjectsearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_SUBJECT_NOT_FOUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }



}
