package com.letscode.hogwartsRegistration.service;

import com.letscode.hogwartsRegistration.dto.StudentRequest;
import com.letscode.hogwartsRegistration.dto.StudentResponse;

public interface StudentService {

  StudentResponse registerStudent(StudentRequest studentRequest);

  StudentResponse getStudentById(Integer id);
}
