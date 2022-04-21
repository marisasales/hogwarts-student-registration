package com.letscode.hogwartsRegistration.repository;

import com.letscode.hogwartsRegistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
