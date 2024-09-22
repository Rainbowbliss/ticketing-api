package hu.otpmobile.ticketing.api.service;

import hu.otpmobile.ticketing.api.client.core.CoreClient;
import hu.otpmobile.ticketing.api.client.core.dto.CoreUserDetails;
import hu.otpmobile.ticketing.api.client.ticket.TicketClient;
import hu.otpmobile.ticketing.api.client.ticket.dto.ReservationResponse;
import hu.otpmobile.ticketing.api.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.api.web.dto.EventsResponse;
import hu.otpmobile.ticketing.api.web.dto.PaymentRequest;
import hu.otpmobile.ticketing.api.web.dto.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

  private final CoreClient coreClient;
  private final TicketClient ticketClient;

  public EventsResponse getEvents(String token) {
    validateUser(token);
    return ticketClient.getEvents();
  }

  public EventDetailsResponse getEvent(String token, Long id) {
    validateUser(token);
    return ticketClient.getEvent(id);
  }

  public ReservationResponse pay(String token, PaymentRequest paymentRequest) {
    var userDetails = validateUser(token);

    var request = new ReservationRequest(paymentRequest.getEventId(),
        paymentRequest.getSeatId(), paymentRequest.getCardId(), userDetails.getUserId(),
        userDetails.getCardBalance());
    return ticketClient.reserveSeat(request);
  }

  private CoreUserDetails validateUser(String token) {
    return coreClient.validateUser(token);
  }
}
