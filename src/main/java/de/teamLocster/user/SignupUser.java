package de.teamLocster.user;

import de.teamLocster.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * Data Transfer Object to send registration information to backend
 */
@Getter
@Setter
public class SignupUser
{
    @NotNull
    @Size(min=1, message = "firstName must not be empty")
    private String firstName;

    @NotNull
    @Size(min=1, message = "Lastname must not be empty")
    private String lastName;

    @NotNull
    private String birthday;

    @NotNull
    private Sex sex;

    @Email
    @NotNull
    @Size(min=1, message = "emailAddress must not be empty")
    private String emailAddress;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Password unsafe")
    @NotNull
    @Size(min=1, message = "password must not be empty")
    private String password;
    private String passwordRepeat;
}
