package com.example.classroomapi.models;

import com.example.classroomapi.help_package.Type_assistance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "asistencia")
public class Assistance {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_asistencia")
    private Integer assistance_id;

    @Column (name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column (name = "estado_asistencia", nullable = false)
    private Type_assistance type_assistance;

    //creando relacion de muchos(estudiantes) a una(asistencia)
    @ManyToOne
    @JoinColumn(name="fk_id_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference ("asistencia_estudiante")
    private Student estudiante;


    //creando relacion de muchos(asistencias) a una(curso)
    @ManyToOne
    @JoinColumn(name="fk_id_curso",referencedColumnName = "id_curso")
    @JsonBackReference ("curso_asistencia")
    private Course curso;




    public Assistance() {
    }

    public Assistance(Integer assistance_id, Date date, Type_assistance type_assistance) {
        this.assistance_id = assistance_id;
        this.date = date;
        this.type_assistance = type_assistance;
    }

    public Integer getAssistance_id() {
        return assistance_id;
    }

    public void setAssistance_id(Integer assistance_id) {
        this.assistance_id = assistance_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type_assistance getType_assistance() {
        return type_assistance;
    }

    public void setType_assistance(Type_assistance type_assistance) {
        this.type_assistance = type_assistance;
    }
}
