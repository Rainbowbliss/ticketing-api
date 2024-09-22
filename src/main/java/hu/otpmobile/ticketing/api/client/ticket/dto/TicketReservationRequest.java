package hu.otpmobile.ticketing.api.client.ticket.dto;

import lombok.Data;

@Data
public class TicketReservationRequest {

  private Long eventId;
  private String seatId;
  private String cardId;
  private Long userId;
}
