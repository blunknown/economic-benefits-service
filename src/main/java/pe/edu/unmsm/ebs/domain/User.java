package pe.edu.unmsm.ebs.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {

    private long id;
    private String username;
    private String password;
    private String names;
    private String surnames;
    private String dni;
    private String mobileNumber;
    private Set<Role> roles;

}
