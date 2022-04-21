package com.letscode.hogwartsRegistration.service.impl;

import com.letscode.hogwartsRegistration.client.GetHouseInfoClient;
import com.letscode.hogwartsRegistration.client.GetHouseKeyClient;
import com.letscode.hogwartsRegistration.dto.StudentRequest;
import com.letscode.hogwartsRegistration.dto.StudentResponse;
import com.letscode.hogwartsRegistration.model.Student;
import com.letscode.hogwartsRegistration.repository.StudentRepository;
import com.letscode.hogwartsRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired StudentRepository studentRepository;

  @Autowired GetHouseKeyClient getHouseKeyClient;

  @Autowired GetHouseInfoClient getHouseInfoClient;

  @Override
  public StudentResponse registerStudent(StudentRequest studentRequest) {
    Student student = new Student(studentRequest);
    student.setSortingHatKey(getHouseKeyClient.execute().getSortingHatChoice());

    var houseInfo = getHouseInfoClient.execute(student.getSortingHatKey());

    return new StudentResponse(studentRepository.save(student), houseInfo);
  }

  @Override
  public StudentResponse getStudentById(Integer id) {
    var student =
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    var houseInfo = getHouseInfoClient.execute(student.getSortingHatKey());

    return new StudentResponse(student, houseInfo);
  }
}
