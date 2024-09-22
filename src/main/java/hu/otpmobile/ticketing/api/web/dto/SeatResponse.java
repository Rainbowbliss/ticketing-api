package hu.otpmobile.ticketing.api.web.dto;

import hu.otpmobile.ticketing.api.enumeration.Currency;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class SeatResponse {

  private String id;
  private BigDecimal price;
  private Currency currency;
  private boolean reserved;
}
