package de.teamLocster.guestbook;

import de.teamLocster.core.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestbookEntryRepository extends BaseRepository<GuestbookEntry>
{
}
