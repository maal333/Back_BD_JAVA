package com.example.classroomapi.services;



import com.example.classroomapi.models.Student;
import com.example.classroomapi.repositorios.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStudent{

    @Autowired
    IStudentRepository repository;

    public Student saveStudent (Student dataStudent) throws Exception{

        try {
            return  this.repository.save(dataStudent);
        }catch (Exception error) {
            throw new Exception();

        }
    }

    //metodo para guardraTodo

    public List<Student> studentList () throws Exception{

        try {
            return  this.repository.findAll();
        }catch (Exception error) {
            throw  new Exception();
        }
    }



}
