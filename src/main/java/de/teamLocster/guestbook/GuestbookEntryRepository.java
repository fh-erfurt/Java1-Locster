package de.teamLocster.guestbook;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.core.DBController;
import de.teamLocster.guestbook.GuestbookEntry;

public class GuestbookEntryRepository extends BaseRepository<GuestbookEntry>
{
    public GuestbookEntryRepository() {
        super(GuestbookEntry.class, DBController.getManager().getEntityManager());
    }
}
