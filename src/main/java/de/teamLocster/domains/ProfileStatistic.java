package de.teamLocster.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileStatistic extends BaseEntity {

    private int visitsCount;
    private int visitorsCount;
    @ManyToMany
    @JoinTable(
            name = "last_visits",                           // TODO naming
            joinColumns = @JoinColumn(name="profileStatistic_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User> lastVisitors = new HashSet<>();
}
