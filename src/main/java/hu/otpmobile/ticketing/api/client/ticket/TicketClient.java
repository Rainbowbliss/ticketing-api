package hu.otpmobile.ticketing.api.client.ticket;

import hu.otpmobile.ticketing.api.client.ticket.dto.ReservationResponse;
import hu.otpmobile.ticketing.api.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.api.web.dto.EventsResponse;
import hu.otpmobile.ticketing.api.web.dto.ReservationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TicketClient {

  private static final String BASE_URL = "/api/v1/events";

  @Value("${app.urls.ticket}")
  private String ticketUrl;

  RestClient restClient = RestClient.create();


  public EventsResponse getEvents() {
    return restClient
        .get()
        .uri(ticketUrl + BASE_URL)
        .retrieve()
        .body(EventsResponse.class);
  }

  public EventDetailsResponse getEvent(Long id) {
    return restClient
        .get()
        .uri(ticketUrl + BASE_URL + "/" + id)
        .retrieve()
        .body(EventDetailsResponse.class);
  }

  public ReservationResponse reserveSeat(ReservationRequest reservationRequest) {
    return restClient
        .post()
        .uri(ticketUrl + BASE_URL + "/reserve")
        .contentType(MediaType.APPLICATION_JSON)
        .body(reservationRequest)
        .retrieve()
        .body(ReservationResponse.class);
  }
}
