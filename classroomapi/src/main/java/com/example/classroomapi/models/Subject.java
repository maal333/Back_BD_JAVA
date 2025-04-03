package com.example.classroomapi.models;
//MATERIA

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materia")
public class Subject {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_materia")
    private Integer subject_id;

    @Column(name = "nombre_materia", length = 100, nullable = false)
    private String name_Subject;


    //creando relacion de una(materia) a muchas(calificaciones)
    @OneToMany(mappedBy = "materia")
    @JsonManagedReference ("calificacion_materia")
    private List<Qualifications>calificacion;

    public Subject() {
    }

    public Subject(Integer subject_id, String name_Subject) {
        this.subject_id = subject_id;
        this.name_Subject = name_Subject;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getName_Subject() {
        return name_Subject;
    }

    public void setName_Subject(String name_Subject) {
        this.name_Subject = name_Subject;
    }
}
