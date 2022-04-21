package com.letscode.hogwartsRegistration.dto;

import com.letscode.hogwartsRegistration.dto.client.HouseInfo;
import com.letscode.hogwartsRegistration.model.Student;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResponse {

    private String name;
    private String grade;
    private HouseInfo houseInfo;

    public StudentResponse(Student student, HouseInfo houseInfo) {
        this.name = student.getName();
        this.grade = student.getGrade();
        this.houseInfo = houseInfo;
    }
}
