package pe.edu.unmsm.ebs.infrastructure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_type_id")
    private Long applicationTypeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "beneficiary_names")
    private String beneficiaryNames;

    @Column(name = "beneficiary_surnames")
    private String beneficiarySurnames;

    @Column(name = "beneficiary_dni")
    private String beneficiaryDni;

    @Column(name = "beneficiary_email")
    private String beneficiaryEmail;

    @Column(name = "beneficiary_mobile_number")
    private String beneficiaryMobileNumber;

    private Double amount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String status;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "application_type_id", insertable = false, updatable = false)
    private ApplicationTypeEntity applicationTypeEntity;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;

}
