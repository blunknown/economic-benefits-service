package pe.edu.unmsm.ebs.application.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private String names;
    private String surnames;
    private String dni;
    private String mobileNumber;
    private Set<String> roles;

}
