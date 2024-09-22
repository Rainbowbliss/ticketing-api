package hu.otpmobile.ticketing.api.service;

import hu.otpmobile.ticketing.api.client.ticket.TicketClient;
import hu.otpmobile.ticketing.api.web.dto.EventItemResponse;
import hu.otpmobile.ticketing.api.web.dto.EventResponse;
import hu.otpmobile.ticketing.api.web.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

  private final TicketClient ticketClient;

  public List<EventItemResponse> getEvents() {
    return ticketClient.getEvents();
  }

  public EventResponse getEvent(Long id) {
    return ticketClient.getEvent(id);
  }

  public Long pay(PaymentRequest paymentRequest) {
    return ticketClient.reserveSeat(paymentRequest);
  }
}
