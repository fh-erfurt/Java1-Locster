package de.teamLocster.domains;

import lombok.*;

import javax.persistence.Entity;

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
    private int relationshipStatusID;
    private String profilePicture; // String?
    private String personalInfo;
    private int sexID;

}
