package hu.otpmobile.ticketing.api.web.rest;

import hu.otpmobile.ticketing.api.client.ticket.dto.ReservationResponse;
import hu.otpmobile.ticketing.api.service.EventService;
import hu.otpmobile.ticketing.api.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.api.web.dto.EventsResponse;
import hu.otpmobile.ticketing.api.web.dto.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventResource {

  private final EventService eventService;

  @GetMapping
  private EventsResponse getEvents(@RequestHeader("User-Token") String userToken) {
    return eventService.getEvents(userToken);
  }

  @GetMapping("/{id}")
  private EventDetailsResponse getEvent(@RequestHeader("User-Token") String userToken,
      @PathVariable Long id) {
    return eventService.getEvent(userToken, id);
  }

  @PostMapping("/pay")
  private ReservationResponse reserveSeat(@RequestHeader("User-Token") String userToken,
      @RequestBody @Valid PaymentRequest paymentRequest) {
    return eventService.pay(userToken, paymentRequest);
  }
}
