package com.example.classroomapi.services;


import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Course;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.repositorios.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    //metodo buscarporId
    public Course searchcoursebyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Course> courseImlookingfor=this.repository.findById(id);
            if (courseImlookingfor.isPresent()){
                return courseImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_COURSE_NOT_FUND.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }
    //metodo para modificar

    public Course modifyTeacher(Integer id, Course datosnuevoscurso)throws Exception{

        try{
            Optional<Course> courseImlookingfortoedit  =this.repository.findById(id);

            if (courseImlookingfortoedit.isPresent()){

                //modificar docente
                courseImlookingfortoedit.get().setName(datosnuevoscurso.getName());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(courseImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_COURSE_NOT_FUND.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }
    //metodo para eliminar

    public boolean deletecourse(Integer id)throws  Exception {

        try {
            Optional<Course> coursesearch = this.repository.findById(id);
            if (coursesearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_COURSE_NOT_FUND.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }


}
