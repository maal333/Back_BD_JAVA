package com.example.classroomapi.services;

import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.models.Qualifications;
import com.example.classroomapi.repositorios.IQualificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //metodo para buscarunoporID
    public Qualifications searchdocentbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Qualifications>    qualificationsImlookingfor=this.repository.findById(id);
            if (qualificationsImlookingfor.isPresent()){
                return qualificationsImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_QUALIFICATIONS_NOT_FUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }
    //metodo para modificar

    public Qualifications modifyTeacher(Integer id, Qualifications datosnuevosdocalifi)throws Exception{

        try{
            Optional<Qualifications> QualificattionsImlookingfortoedit  =this.repository.findById(id);

            if (QualificattionsImlookingfortoedit.isPresent()){

                //modificar docente
                QualificattionsImlookingfortoedit.get().setNote(datosnuevosdocalifi.getNote());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(QualificattionsImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_QUALIFICATIONS_NOT_FUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }
    }
    //metodo para eliminar

    public boolean deletequalifications(Integer id)throws  Exception {

        try {
            Optional<Qualifications> qualificationssearch = this.repository.findById(id);
            if (qualificationssearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_QUALIFICATIONS_NOT_FUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }











}
