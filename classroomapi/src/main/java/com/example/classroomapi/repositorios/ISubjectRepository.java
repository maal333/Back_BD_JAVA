package com.example.classroomapi.repositorios;


import com.example.classroomapi.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject,Integer> {
}
