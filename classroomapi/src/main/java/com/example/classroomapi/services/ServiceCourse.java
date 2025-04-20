package com.example.classroomapi.services;


import com.example.classroomapi.models.Course;
import com.example.classroomapi.repositorios.IAssistanceRepository;
import com.example.classroomapi.repositorios.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCourse {

    @Autowired
    ICourseRepository repository;

    public Course saveCourse (Course dataCourse) throws Exception{

        try{
            return this.repository.save(dataCourse);

        } catch (Exception error) {
            throw new Exception();

        }

    }

    // metodo para buscarTodo
    public List<Course>  courseList() throws Exception{
        try {
            return  this.repository.findAll();
        }catch (Exception error){
            throw new Exception();
        }
    }



}
