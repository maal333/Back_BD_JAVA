package com.example.classroomapi.models;
//Inscripción
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;
@Entity
@Table(name = "Inscripción")
public class Registration {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id_inscripcion")
    private Integer registration_id;

    @Column (name = "fecha_inscripcion")
    private Timestamp registration_date;

    // creando relacion (muchas inscripciones a 1 estudiante)
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference("estudiante_inscripcion")
    private Student estudiante;


    public Registration() {
    }

    public Registration(Integer registration_id, Timestamp registration_date) {
        this.registration_id = registration_id;
        this.registration_date = registration_date;
    }

    public Integer getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(Integer registration_id) {
        this.registration_id = registration_id;
    }

    public Timestamp getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Timestamp registration_date) {
        this.registration_date = registration_date;
    }
}
