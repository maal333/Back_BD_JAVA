package com.example.classroomapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "calificaciones")
public class Qualifications {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_calificacione")
    private Integer qualifications_id;

    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private BigDecimal note;

    @Column (name = "fecha_evaluacion",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date evaluation_date;



    //creaando relacion de muchos (calificaciones) a uno (estudiantes)
    @ManyToOne
    @JoinColumn(name="fk_id_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference  ("calificaciones_estudiante")
    private Student estudiante;



    //creaando relacion de muchos (calificaciones) a uno (materia)
    @ManyToOne
    @JoinColumn(name="fk_id_materia",referencedColumnName = "id_materia")
    @JsonBackReference ("calificacion_materia")
    private Subject materia;

    public Qualifications() {
    }

    public Qualifications(Integer qualifications_id, BigDecimal note, Date evaluation_date) {
        this.qualifications_id = qualifications_id;
        this.note = note;
        this.evaluation_date = evaluation_date;
    }

    public Integer getQualifications_id() {
        return qualifications_id;
    }

    public void setQualifications_id(Integer qualifications_id) {
        this.qualifications_id = qualifications_id;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Date getEvaluation_date() {
        return evaluation_date;
    }

    public void setEvaluation_date(Date evaluation_date) {
        this.evaluation_date = evaluation_date;
    }
}
