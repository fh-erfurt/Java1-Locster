package de.teamLocster.domains;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sex extends BaseEntity {

    private String description;

}
