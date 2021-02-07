package pe.edu.unmsm.ebs.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Application {

    private long id;
    private long applicationTypeId;
    private long userId;
    private String userNames;
    private String userSurnames;
    private String userDni;
    private String beneficiaryNames;
    private String beneficiarySurnames;
    private String beneficiaryDni;
    private String beneficiaryEmail;
    private String beneficiaryMobileNumber;
    private String applicationTypeName;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String comment;

}
