package com.hotelserviceapp.Exception;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {
    private String message;
    private boolean success;
    private HttpStatus status;
    private LocalDateTime timeStamp;
}
