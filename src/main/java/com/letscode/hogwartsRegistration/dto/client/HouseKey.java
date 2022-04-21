package com.letscode.hogwartsRegistration.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HouseKey {

  @JsonProperty("sorting-hat-choice")
  private String sortingHatChoice;
}
