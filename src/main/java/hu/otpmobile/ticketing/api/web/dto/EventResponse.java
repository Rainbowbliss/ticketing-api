package hu.otpmobile.ticketing.api.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventResponse {

  private Long eventId;
  private String title;
  private String location;
  private LocalDateTime startTimeStamp;
  private LocalDateTime endTimeStamp;
}
