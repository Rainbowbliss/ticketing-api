package hu.otpmobile.ticketing.api.web.dto;

import lombok.Data;
import java.util.List;

@Data
public class EventResponse {

  private Long eventId;
  private List<SeatResponse> seats;
}
