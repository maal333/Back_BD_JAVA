package com.example.classroomapi.services;


import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Assistance;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.repositorios.IAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAssistance {

    @Autowired

    IAssistanceRepository repository;

    //metodo para guardartodo

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

    //metodo para buscarunoporId

    public Assistance searchassistencebyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Assistance> assitanceImlookingfor=this.repository.findById(id);
            if (assitanceImlookingfor.isPresent()){
                return assitanceImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_ASSISTANCE_NOT_FUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }
    //metodo para modificar

    public Assistance modifyassistance(Integer id, Assistance datosnuevosasistencia)throws Exception{

        try{
            Optional<Assistance> assistanceImlookingfortoedit  =this.repository.findById(id);

            if (assistanceImlookingfortoedit.isPresent()){

                //modificar docente
                assistanceImlookingfortoedit.get().setType_assistance(datosnuevosasistencia.getType_assistance());
                //despues de modifciar se guarda la modificaiones en el repositorio

                return this.repository.save(assistanceImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_ASSISTANCE_NOT_FUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }
    //metodo para eliminar

    public boolean deleteassistance(Integer id)throws  Exception {

        try {
            Optional<Assistance> assistancesearch = this.repository.findById(id);
            if (assistancesearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_ASSISTANCE_NOT_FUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }




}