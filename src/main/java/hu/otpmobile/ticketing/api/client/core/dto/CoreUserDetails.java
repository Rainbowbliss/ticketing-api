package hu.otpmobile.ticketing.api.client.core.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CoreUserDetails {

  private Long userId;
  private String cardId;
  private BigDecimal cardBalance;
}
