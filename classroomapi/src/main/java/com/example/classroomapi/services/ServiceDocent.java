package com.example.classroomapi.services;

import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.repositorios.IDocentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Docent searchdocentbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Docent> docentImlookingfor=this.repository.findById(id);
            if (docentImlookingfor.isPresent()){
                return docentImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_DOCENT_NOT_FOUNT.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }


    //metodo para modificar

    public Docent modifydocent(Integer id, Docent datosnuevosdocente)throws Exception{

        try{
            Optional<Docent> docentImlookingfortoedit  =this.repository.findById(id);

            if (docentImlookingfortoedit.isPresent()){

                //modificar docente
                docentImlookingfortoedit.get().setSpecialty(datosnuevosdocente.getSpecialty());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(docentImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_DOCENT_NOT_FOUNT.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }


    //metodo para eliminar

    public boolean deletedocent(Integer id)throws  Exception {

        try {
            Optional<Docent> docentsearch = this.repository.findById(id);
            if (docentsearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_DOCENT_NOT_FOUNT.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }


}
