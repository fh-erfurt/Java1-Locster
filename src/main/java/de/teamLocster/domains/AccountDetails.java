package de.teamLocster.domains;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails extends BaseEntity {

    // username wurde rausgeschmissen
    private String eMailAddress;
    private String passwordHash;
}
