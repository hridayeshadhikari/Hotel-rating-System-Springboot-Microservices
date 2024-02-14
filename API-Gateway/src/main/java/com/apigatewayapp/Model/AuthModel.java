package com.apigatewayapp.Model;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthModel {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expiredAt;
    private Collection<String> authorities;
}
