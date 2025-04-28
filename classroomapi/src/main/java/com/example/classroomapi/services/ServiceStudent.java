package com.example.classroomapi.services;



import com.example.classroomapi.help_package.MesaageAPI;
import com.example.classroomapi.models.Docent;
import com.example.classroomapi.models.Student;
import com.example.classroomapi.repositorios.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStudent{

    @Autowired
    IStudentRepository repository;

    //metodo paara guardar

    public Student saveStudent (Student dataStudent) throws Exception{

        try {
            return  this.repository.save(dataStudent);
        }catch (Exception error) {
            throw new Exception();

        }
    }

    //metodo para buscartodo

    public List<Student> studentList () throws Exception{

        try {
            return  this.repository.findAll();
        }catch (Exception error) {
            throw  new Exception();
        }
    }

    //metodo para buscarunoporID
    public Student searchstudentbyID(Integer id)throws Exception{
        try{

            //craer un datoopcional

            Optional<Student> studentImlookingfor=this.repository.findById(id);
            if (studentImlookingfor.isPresent()){
                return studentImlookingfor.get();

            }else {
                throw new Exception(MesaageAPI.ERROR_STUDENT_NOT_FOUNT.getMessage());

            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }

    }

    //metodo para modificar

    public Student modifystudent(Integer id, Student datosnuevosstudent)throws Exception{

        try{
            Optional<Student> studentImlookingfortoedit  =this.repository.findById(id);

            if (studentImlookingfortoedit.isPresent()){

                //modificar docente
                studentImlookingfortoedit.get().setDirection(datosnuevosstudent.getDirection());
                //despues de modifciar se gurda la modificaiones en el repositorio

                return this.repository.save(studentImlookingfortoedit.get());

            }else {
                throw  new Exception(MesaageAPI.ERROR_STUDENT_NOT_FOUNT.getMessage());
            }

        }catch (Exception error){
            throw  new Exception(error.getMessage());


        }
    }
    //metodo para eliminar

    public boolean deletestudent(Integer id)throws  Exception {

        try {
            Optional<Student> studentsearch = this.repository.findById(id);
            if (studentsearch.isPresent()) {

                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception((MesaageAPI.ERROR_STUDENT_NOT_FOUNT.getMessage()));
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }



}
