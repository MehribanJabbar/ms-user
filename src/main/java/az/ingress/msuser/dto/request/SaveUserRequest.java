package az.ingress.msuser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequest {
    private String name;
    private String surname;
    private String userName;
    private String email;
    private LocalDate birthDate;
}
