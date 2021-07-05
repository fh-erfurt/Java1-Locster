package de.teamLocster.user;

import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class PublicUser
{
    PublicUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();

        // TODO
        this.birthDay = user.getBirthDay();

        this.relationshipStatus = user.getRelationshipStatus();
        this.sex = user.getSex();

        this.region = user.getRegion();
        this.isOnline = user.getIsOnline();
    }

    private String firstName;
    private String lastName;

    Timestamp birthDay;

    private RelationshipStatus relationshipStatus;
    private Sex sex;

    private String region;
    Boolean isOnline;
}
