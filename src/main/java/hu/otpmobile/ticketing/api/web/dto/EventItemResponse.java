package hu.otpmobile.ticketing.api.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventItemResponse {

  private Long eventId;
  private String title;
  private String location;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

}
