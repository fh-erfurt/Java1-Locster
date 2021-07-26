package de.teamLocster.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.teamLocster.enums.Sex;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

/**
 * Data Transfer Object to send registration information to backend
 */
@Getter
@Setter
public class SignupUser
{
    @NotNull
    @Size(min=1, message = "Vorname darf nicht leer sein!")
    private String firstName;

    @NotNull
    @Size(min=1, message = "Nachname darf nicht leer sein!")
    private String lastName;

    @NotNull
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") didn't work!
    @Pattern(regexp = "^([0-9]{4})-([0-1][0-9])-([0-3][0-9])$", message = "Bitte gültiges Datum eingeben!")
    private String birthday;

    @NotNull
    private Sex sex;

    @Email
    @NotNull
    @Size(min=1, message = "Bitte eine gültige Email-Adresse angeben!")
    private String emailAddress;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[@#^!'§$%&/()=*\\-+,.;:_<>?|]).{8,}$", message = "Password unsafe")
    @NotNull
    @Size(min=1, message = "password must not be empty")
    private String password;
    private String passwordRepeat;
}
