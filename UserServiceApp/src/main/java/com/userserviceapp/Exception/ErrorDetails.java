package com.userserviceapp.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {
    private String message;
    private boolean success;
    private HttpStatus status;
}
