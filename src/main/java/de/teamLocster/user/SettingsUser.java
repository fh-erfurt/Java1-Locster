package de.teamLocster.user;

import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * Data Transfer Object to edit personal user information
 */
@Getter
@Setter
@NoArgsConstructor
public class SettingsUser
{
    public SettingsUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.region = user.getRegion();
        this.birthday = user.getBirthDay().toString();
        this.sex = user.getSex();
        this.relationshipStatus = user.getRelationshipStatus();
        this.occupation = user.getOccupation();
        this.emailAddress = user.getEmailAddress();
        this.password = null;
        this.onlineStatus = user.getOnlineStatus();
        this.personalStatus = user.getPersonalStatus();
    }

    @NotNull
    @Size(min=1, message = "Vorname darf nicht leer sein!")
    private String firstName;

    @NotNull
    @Size(min=1, message = "Nachname darf nicht leer sein!")
    private String lastName;

    @NotNull
    String region;

    @NotNull
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") didn't work!
    @Pattern(regexp = "^([0-9]{4})-([0-1][0-9])-([0-3][0-9])$", message = "Bitte gültiges Datum eingeben!")
    private String birthday;

    @NotNull
    private Sex sex;

    @NotNull
    private RelationshipStatus relationshipStatus;

    @NotNull
    private String occupation;

    @Email
    @NotNull
    @Size(min=1, message = "Bitte eine gültige Email-Adresse angeben!")
    private String emailAddress;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[@#^!'§$%&/()=*\\-+,.;:_<>?|]).{8,}|$", message = "Password unsafe")
    private String password;
    private String passwordRepeat;

    private String personalStatus;

    @NotNull
    private OnlineStatus onlineStatus;
}
