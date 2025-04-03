package com.example.classroomapi.repositorios;

import com.example.classroomapi.models.Qualifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQualificationsRepository extends JpaRepository<Qualifications,Integer> {
}
