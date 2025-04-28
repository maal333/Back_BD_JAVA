package com.example.classroomapi.services;


import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.models.Qualifications;
import com.example.classroomapi.models.Registration;
import com.example.classroomapi.repositorios.IQualificationsRepository;
import com.example.classroomapi.repositorios.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    //metodo para buscarunoporID
    public Registration searchregistrationbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Registration> registrationImlookingfor=this.repository.findById(id);
            if (registrationImlookingfor.isPresent()){
                return registrationImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_REGISTRATION_NOT_FUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }

    //metodo para modificar

    public Registration modifyregistration(Integer id, Registration datosnuevosregistro)throws Exception{

        try{
            Optional<Registration> registrationImlookingfortoedit  =this.repository.findById(id);

            if (registrationImlookingfortoedit.isPresent()){

                //modificar docente
                registrationImlookingfortoedit.get().setRegistration_date(datosnuevosregistro.getRegistration_date());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(registrationImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_REGISTRATION_NOT_FUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }


    //metodo para eliminar

    public boolean deleteregistration(Integer id)throws  Exception {

        try {
            Optional<Registration> registrationsearch = this.repository.findById(id);
            if (registrationsearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_REGISTRATION_NOT_FUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }




}
