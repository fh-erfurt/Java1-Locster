package de.teamLocster.guestbook;

import de.teamLocster.core.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
