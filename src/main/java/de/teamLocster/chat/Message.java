package de.teamLocster.chat;


import de.teamLocster.core.BaseEntity;
import de.teamLocster.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * has not yet been implemented
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "chat", referencedColumnName = "id")
    private Chat chat;
    @ManyToMany
    @JoinTable(
            name = "read_by",                           // TODO time of read
            joinColumns = @JoinColumn(name = "message"),
            inverseJoinColumns = @JoinColumn(name = "user")
    )
    private Set<User> readBy;
    private String text;
    private Date sentAt;
}
