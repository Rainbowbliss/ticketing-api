package hu.otpmobile.ticketing.api.web.dto;

import lombok.Data;

@Data
public class PaymentRequest {

  private Long eventId;
  private String seatId;
  private String cardId;
}
