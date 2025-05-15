package com.example.classroomapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_estudiante")
    private Integer student_id;

    @Column (name = "fecha_nacimiento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column (name = "grado",nullable = false)
    private Integer grade;

    @Column(name = "direccion",length = 300, nullable = false )
    private String direction;

   //creando relacion de one(Estudinate) a many (calificacion)
    @OneToMany (mappedBy = "estudiante")
    @JsonManagedReference ("calificacion_estudiante")
    private List<Qualifications>calificacion;


    // creando relacion de one(estudiante) a  many(asistencia)
    @OneToMany(mappedBy = "estudiante")  // Debe coincidir con el nombre del campo en Assistance
    @JsonManagedReference ("asistencia_estudiante")
    private List<Assistance> asistencia;

    // creando relacion (1 estudiante a muchas inscripciones)
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference("estudiante_inscripcion")
    private List<Registration> inscripciones;



    public Student() {
    }

    public Student(Integer student_id, Date birthdate, Integer grade, String direction) {
        this.student_id = student_id;
        this.birthdate = birthdate;
        this.grade = grade;
        this.direction = direction;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


}



