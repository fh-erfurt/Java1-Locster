package de.teamLocster.user;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo extends BaseEntity
{

    private String firstName;
    private String lastName;
    private String region;
    private Date birthDay;    // TODO Date?
    private String occupation;
    @Enumerated(EnumType.ORDINAL)
    private RelationshipStatus relationshipStatus;
    private String profilePicture; // String?
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
}

//@OneToOne(cascade = CascadeType.PERSIST)
//public User user;
