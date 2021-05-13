package de.teamLocster.domains;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo extends BaseEntity {

    private String firstName;
    private String lastName;
    private String region;
    private String birthDay;    // Date?
    private String occupation;
    private Long relationshipStatusID;
    private String profilePicture; // String?
    private String personalInfo;
    private Long sexID;
}

//@OneToOne(cascade = CascadeType.PERSIST)
//public User user;
