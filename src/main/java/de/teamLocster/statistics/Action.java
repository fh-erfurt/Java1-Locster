package de.teamLocster.statistics;

import com.sun.istack.NotNull;
import de.teamLocster.core.BaseEntity;
import de.teamLocster.enums.ActionTypes;
import de.teamLocster.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Action extends BaseEntity
{
    @ManyToOne(optional = false)
    private User actor;
    @ManyToOne
    private User acted;
    // @Column() hier können constraints rein
    @Enumerated(EnumType.ORDINAL)
    private ActionTypes actionType;
}
