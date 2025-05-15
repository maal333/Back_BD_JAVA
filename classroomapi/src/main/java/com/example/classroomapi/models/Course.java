package com.example.classroomapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="curso")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer course_id;

    @Column(name = "nombre", length = 100, unique = false, nullable = false)
    private String name;


    //creando relacion (muchos a 1 )
    @ManyToOne
    @JoinColumn(name="fk_id_docente",referencedColumnName = "id_docente")
    @JsonBackReference
    private Docent docente;



    //creando relacion  (1 curso  a muchas asistencias)
    @OneToMany(mappedBy = "curso")  // Debe coincidir con el nombre del campo en Assistance
    @JsonManagedReference ("curso_asistencia")
    private List<Assistance> asistencia;



    //relacion de 1 curso a muchas materias
    @OneToMany(mappedBy = "curso")  // Debe coincidir con el nombre del campo en Subject
    @JsonManagedReference("curso_materia")
    private List<Subject> materias;


    public Course() {
    }

    public Course(Integer course_id, String name) {
        this.course_id = course_id;
        this.name = name;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
