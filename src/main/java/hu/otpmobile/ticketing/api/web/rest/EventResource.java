package hu.otpmobile.ticketing.api.web.rest;

import hu.otpmobile.ticketing.api.service.EventService;
import hu.otpmobile.ticketing.api.web.dto.EventItemResponse;
import hu.otpmobile.ticketing.api.web.dto.EventResponse;
import hu.otpmobile.ticketing.api.web.dto.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventResource {

  private final EventService eventService;

  @GetMapping
  private List<EventItemResponse> getEvents() {
    return eventService.getEvents();
  }

  @GetMapping("/{id}")
  private EventResponse getEvent(@PathVariable Long id) {
    return eventService.getEvent(id);
  }

  @PostMapping("/pay")
  private Long reserveSeat(@RequestBody @Valid PaymentRequest paymentRequest) {
    return eventService.pay(paymentRequest);
  }
}
