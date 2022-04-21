package com.letscode.hogwartsRegistration.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class StudentRequest {

  @NotNull @NotEmpty
  private String name;

  @NotNull @NotEmpty
  private String grade;
}
