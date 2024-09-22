package hu.otpmobile.ticketing.api.client.core;

import hu.otpmobile.ticketing.api.client.core.dto.CoreUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CoreClient {

  @Value("${app.urls.core}")
  private String coreUrl;

  RestClient restClient = RestClient.create();

  public CoreUserDetails validateUser(String token) {
    return restClient
        .get()
        .uri(coreUrl + "/api/v1/users/validate")
        .header("User-Token", token)
        .retrieve()
        .body(CoreUserDetails.class);
  }
}
