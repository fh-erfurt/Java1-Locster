package de.teamLocster.chat;

import de.teamLocster.core.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends BaseRepository<Message> {
}
