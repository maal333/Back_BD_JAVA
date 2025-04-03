package com.example.classroomapi.repositorios;

import com.example.classroomapi.models.Docent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//creandolo de la tabla docente

@Repository
public interface IDocentRepository extends JpaRepository<Docent,Integer> {

    //si tengo consultas personalizadas deben ir en este espacion
}
