package de.teamLocster.guestbook;

import de.teamLocster.core.BaseService;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @version 1.0.
 */
@Slf4j
@Service
public class GuestbookEntryService extends BaseService<GuestbookEntry>
{
    GuestbookEntryRepository guestbookEntryRepository;

    @Autowired
    GuestbookEntryService(GuestbookEntryRepository guestbookEntryRepository) {
        this.guestbookEntryRepository = guestbookEntryRepository;
    }

    public List<GuestbookEntry> getReceivedGuestbookEntriesOfUser(User user) {
        return guestbookEntryRepository.findByUserId(user.getId());
    }

    public List<GuestbookEntry> getCreatedGuestbookEntriesOfUser(User user) {
        return guestbookEntryRepository.findByCreatorId(user.getId());
    }

    public void sendPost(User actor, User affected, String content) {
        guestbookEntryRepository.save(new GuestbookEntry(actor, affected, content, Date.from(Instant.now()), null, false));
    }
}
