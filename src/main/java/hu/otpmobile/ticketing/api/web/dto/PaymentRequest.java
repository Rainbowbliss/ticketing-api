package hu.otpmobile.ticketing.api.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {

  @NotNull
  private Long eventId;
  @NotBlank
  private String seatId;
  @NotBlank
  private String cardId;
}
