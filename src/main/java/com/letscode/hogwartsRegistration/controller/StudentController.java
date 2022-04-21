package com.letscode.hogwartsRegistration.controller;

import com.letscode.hogwartsRegistration.dto.StudentRequest;
import com.letscode.hogwartsRegistration.dto.StudentResponse;
import com.letscode.hogwartsRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse registerStudent(@RequestBody @Valid StudentRequest studentRequest) {
    return studentService.registerStudent(studentRequest);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentResponse getStudent(@PathVariable Integer id) {
    return studentService.getStudentById(id);
  }
}