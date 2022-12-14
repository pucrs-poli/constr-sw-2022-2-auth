package br.pucrs.auth.resource;

import br.pucrs.auth.dto.response.AuthenticationResponseDTO;
import br.pucrs.auth.dto.response.TokenIntrospectResponseDTO;
import br.pucrs.auth.dto.response.UserInfoResponseDTO;
import br.pucrs.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthResource {
    private final AuthService authService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthenticationResponseDTO> generateToken(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        return ResponseEntity.ok(this.authService.login(username, password));
    }

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<AuthenticationResponseDTO> refreshToken(@RequestBody() String refreshToken) {
        return ResponseEntity.ok(this.authService.refreshToken(refreshToken));
    }

    @GetMapping("/user-info")
    public ResponseEntity<UserInfoResponseDTO> getUserInfo() {
        return ResponseEntity.ok(this.authService.getUserInfo());
    }

    @GetMapping("/token-introspect")
    public ResponseEntity<TokenIntrospectResponseDTO> tokenIntrospect() {
        return ResponseEntity.ok(this.authService.tokenIntrospect());
    }
}
