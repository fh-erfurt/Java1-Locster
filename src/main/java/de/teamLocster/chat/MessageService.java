package de.teamLocster.chat;

import de.teamLocster.core.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * has not yet been implemented
 */
@Slf4j
@Service
public class MessageService extends BaseService<Message> {
    MessageRepository messageRepository;

    @Autowired
    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
