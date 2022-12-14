package br.pucrs.auth.service.impl;

import br.pucrs.auth.dto.response.AuthenticationResponseDTO;
import br.pucrs.auth.dto.response.TokenIntrospectResponseDTO;
import br.pucrs.auth.dto.response.UserInfoResponseDTO;
import br.pucrs.auth.exceptions.AuthBadRequestException;
import br.pucrs.auth.i18n.Translator;
import br.pucrs.auth.service.AuthService;
import br.pucrs.auth.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final KeycloakService keycloakService;

    private final Translator translator;

    @Override
    public AuthenticationResponseDTO login(String username, String password) {
        if (isNull(username) || isNull(password)) {
            throw new AuthBadRequestException(translator.toLocale("msg_Invalid_User_Or_Password"));
        }

        return this.keycloakService.generateToken(username, password);
    }

    @Override
    public AuthenticationResponseDTO refreshToken(String refreshToken) {
        return this.keycloakService.refreshToken(refreshToken);
    }

    @Override
    public UserInfoResponseDTO getUserInfo() {
        return this.keycloakService.getUserInfo();
    }

    @Override
    public TokenIntrospectResponseDTO tokenIntrospect() {
        return this.keycloakService.tokenIntrospect();
    }
}
