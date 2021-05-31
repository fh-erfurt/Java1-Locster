package de.teamLocster.chat;

import de.teamLocster.core.BaseEntity;
import de.teamLocster.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseEntity
{

    private String name;
    @ManyToMany
    @JoinTable(
            name = "users_in_chats",                           // TODO time of read
            joinColumns = @JoinColumn(name="chat"),
            inverseJoinColumns = @JoinColumn(name="user")
    )
    private Set<User> users = new HashSet<>();
    @OneToMany(mappedBy = "chat")
    private Set<Message> messages = new HashSet<>();
}
