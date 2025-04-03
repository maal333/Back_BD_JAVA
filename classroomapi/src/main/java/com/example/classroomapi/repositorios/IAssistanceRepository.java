package com.example.classroomapi.repositorios;

import com.example.classroomapi.models.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssistanceRepository extends JpaRepository<Assistance, Integer> {


}
