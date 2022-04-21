package com.letscode.hogwartsRegistration.client;

import com.letscode.hogwartsRegistration.dto.client.HouseKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetHouseKeyClient {

  @Value("${hogwarts.registration.client.house.key}")
  private String url;

  public HouseKey execute() {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<HouseKey> houseKeyResponseEntity =
        restTemplate.exchange(url, HttpMethod.GET, entity, HouseKey.class);

    if (houseKeyResponseEntity.getStatusCode().isError()) {
      throw new RuntimeException("Error getting house key");
    }

    return houseKeyResponseEntity.getBody();
  }
}
