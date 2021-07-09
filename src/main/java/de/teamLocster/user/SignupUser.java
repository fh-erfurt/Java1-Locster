package de.teamLocster.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Data Transfer Object to send registration information to backend
 */
@Getter
@Setter
public class SignupUser
{
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String birthday;

    @NotNull
    @NotEmpty
    private String sex;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Password unsafe")
    @NotNull
    @NotEmpty
    private String password;
    private String passwordRepeat;
}
