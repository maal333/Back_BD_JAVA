package com.example.classroomapi.repositorios;


import com.example.classroomapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {



}
