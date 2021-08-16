package de.teamLocster.actions;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.enums.ActionType;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User actor;
    @ManyToOne(fetch = FetchType.LAZY)
    private User affected;
    @Enumerated(EnumType.ORDINAL)
    private ActionType actionType;
}
