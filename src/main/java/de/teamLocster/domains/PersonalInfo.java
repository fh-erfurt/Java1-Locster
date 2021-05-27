package de.teamLocster.domains;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo extends BaseEntity {

    private String firstName;
    private String lastName;
    private String region;
    private Date birthDay;    // TODO Date?
    private String occupation;
    private RelationshipStatus relationshipStatus;
    private String profilePicture; // String?
    private Sex sex;
}

//@OneToOne(cascade = CascadeType.PERSIST)
//public User user;
