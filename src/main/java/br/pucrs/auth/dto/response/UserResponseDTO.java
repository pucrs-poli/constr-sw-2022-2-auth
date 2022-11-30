package br.pucrs.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
