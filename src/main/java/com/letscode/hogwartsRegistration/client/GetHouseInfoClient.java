package com.letscode.hogwartsRegistration.client;

import com.letscode.hogwartsRegistration.dto.client.HouseInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetHouseInfoClient {

  @Value("${hogwarts.registration.client.house.info}")
  private String url;

  public HouseInfo execute(String houseKey) {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<HouseInfo> houseInfoResponseEntity =
        restTemplate.exchange(url, HttpMethod.GET, entity, HouseInfo.class, houseKey);

    if (houseInfoResponseEntity.getStatusCode().isError()) {
      throw new RuntimeException("Error getting house information");
    }

    return houseInfoResponseEntity.getBody();
  }
}
