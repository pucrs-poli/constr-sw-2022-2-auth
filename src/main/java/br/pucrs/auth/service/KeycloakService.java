package br.pucrs.auth.service;

import br.pucrs.auth.dto.request.KeycloakUserCredentialsRequestDTO;
import br.pucrs.auth.dto.request.KeycloakUserRequestDTO;
import br.pucrs.auth.dto.request.UserUpdateRequestDTO;
import br.pucrs.auth.dto.response.AuthenticationResponseDTO;
import br.pucrs.auth.dto.response.TokenIntrospectResponseDTO;
import br.pucrs.auth.dto.response.UserInfoResponseDTO;
import br.pucrs.auth.dto.response.UserResponseDTO;

import java.util.List;

public interface KeycloakService {
    AuthenticationResponseDTO generateToken(String username, String password);

    AuthenticationResponseDTO refreshToken(String refreshToken);

    UserInfoResponseDTO getUserInfo();

    TokenIntrospectResponseDTO tokenIntrospect();

    List<UserResponseDTO> findAllUsers();

    void saveUser(KeycloakUserRequestDTO keycloakUserRequestDTO);

    void updateUser(String id, UserUpdateRequestDTO userUpdateRequestDTO);

    UserResponseDTO findUserById(String id);

    void changePassword(String id, KeycloakUserCredentialsRequestDTO keycloakUserCredentialsRequestDTO);

    void deleteUser(String id);
}
