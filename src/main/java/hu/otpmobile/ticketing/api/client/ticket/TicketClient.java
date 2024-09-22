package hu.otpmobile.ticketing.api.client.ticket;

import hu.otpmobile.ticketing.api.web.dto.EventItemResponse;
import hu.otpmobile.ticketing.api.web.dto.EventResponse;
import hu.otpmobile.ticketing.api.web.dto.PaymentRequest;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TicketClient {


  public List<EventItemResponse> getEvents() {
    return null;
  }

  public EventResponse getEvent(Long id) {
    return null;
  }

  public Long reserveSeat(PaymentRequest paymentRequest) {
    return null;
  }
}
