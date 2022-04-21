package com.letscode.hogwartsRegistration.model;

import com.letscode.hogwartsRegistration.dto.StudentRequest;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "student")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "grade")
  private String grade;

  @Column(name = "sorting_hat_key")
  private String sortingHatKey;

  @Column(name = "created_date")
  @CreatedDate
  private LocalDateTime createdDate;

  @Column(name = "updated_date")
  @LastModifiedDate
  private LocalDateTime updatedDate;

  public Student(StudentRequest studentRequest) {
    this.name = studentRequest.getName();
    this.grade = studentRequest.getGrade();
  }
}
