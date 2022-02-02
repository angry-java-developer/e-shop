package microservice.eshop.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {
    private Long id;
    @Size(max = 256)
    private String username;
    private String firstName;
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;
}
