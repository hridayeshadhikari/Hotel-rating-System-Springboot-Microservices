package com.apigatewayapp.Controller;

import com.apigatewayapp.Model.AuthModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger logger= LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public ResponseEntity<AuthModel> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
    ){
        logger.info("Email id : {}",user.getEmail());

        AuthModel authModel=new AuthModel();
        authModel.setUserId(user.getEmail());
        authModel.setAccessToken(client.getAccessToken().getTokenValue());
        authModel.setRefreshToken(client.getRefreshToken().getTokenValue());
        authModel.setExpiredAt(client.getAccessToken().getExpiresAt().getEpochSecond());

        List<String> authority= user.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).collect(Collectors.toList());

        authModel.setAuthorities(authority);
        return new ResponseEntity<>(authModel, HttpStatus.OK);

    }
}
