package kz.nik.middle.middlesecurity.service;

import kz.nik.middle.middlesecurity.client.KeycloakClient;
import kz.nik.middle.middlesecurity.dto.UserCreateDto;
import kz.nik.middle.middlesecurity.dto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final KeycloakClient keycloakClient;

    public void addUser(UserCreateDto userCreateDto){
        log.info("Creating user with username: {}", userCreateDto.getUsername());
        UserRepresentation userRepresentation = keycloakClient.createUser(userCreateDto);
    }

    public String signIn(UserSignInDto userSignInDto){
        return keycloakClient.signIn(userSignInDto);
    }

    public void changePassword(String username, String newPassword){
        keycloakClient.changePassword(username, newPassword);
    }
}