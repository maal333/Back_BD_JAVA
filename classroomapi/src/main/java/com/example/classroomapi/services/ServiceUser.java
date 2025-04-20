package com.example.classroomapi.services;


import com.example.classroomapi.models.User;
import com.example.classroomapi.repositorios.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
