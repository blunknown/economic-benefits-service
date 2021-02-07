package pe.edu.unmsm.ebs.application.web.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private String names;
    private String surnames;
    private String dni;
    private String mobileNumber;
    private Set<String> roles;

}
