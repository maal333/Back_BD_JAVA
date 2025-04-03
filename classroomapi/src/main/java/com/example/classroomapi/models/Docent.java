package com.example.classroomapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="docente")
public class Docent {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_docente")
    private Integer docent_id;

    @Column (name = "especialidad", length = 100, unique = false, nullable = false)
    private  String specialty;


    //creando relacion  (1 a muchos)
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Course> cursos;
    // se nombre hacia donde va , hacia donde  se relaciona, se tiene en ceunta donde inicia



    public Docent() {
    }

    public Docent(Integer docent_id, String specialty) {
        this.docent_id = docent_id;
        this.specialty = specialty;

    }

    public Integer getDocent_id() {
        return docent_id;
    }

    public void setDocent_id(Integer docent_id) {
        this.docent_id = docent_id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
