package com.letscode.hogwartsRegistration.dto.client;

import lombok.Data;

import java.util.List;

@Data
public class HouseInfo {

  private String name;
  private String animal;
  private String founder;
  private List<Value> values;
}
