package com.example.classroomapi.services;


import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.models.User;
import com.example.classroomapi.repositorios.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser{

    @Autowired
    IUserRepository repository;

    public User saveUser (User dataUser) throws Exception{

        try {
            return  this.repository.save(dataUser);
        }catch (Exception error) {
            throw new Exception();

        }
    }
    //metodo paar buscarTodo
    public List<User> userList () throws Exception{

        try{

            return  this.repository.findAll();

        } catch (Exception error){
            throw new Exception();
        }

    }

    //metodo para buscarunoporID
    public User searchuserbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<User> userImlookingfor=this.repository.findById(id);
            if (userImlookingfor.isPresent()){
                return userImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_USER_NOT_FOUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }


    //metodo para modificar

    public User modifydocent(Integer id, User datosnuevosusuario)throws Exception{

        try{
            Optional<User> userImlookingfortoedit  =this.repository.findById(id);

            if (userImlookingfortoedit.isPresent()){

                //modificar usuario
                userImlookingfortoedit.get().setEmail(datosnuevosusuario.getEmail());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(userImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_USER_NOT_FOUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }


    //metodo para eliminar

    public boolean deleteuser(Integer id)throws  Exception {

        try {
            Optional<User> usersearch = this.repository.findById(id);
            if (usersearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_USER_NOT_FOUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }









}
