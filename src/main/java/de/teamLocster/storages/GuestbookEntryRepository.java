package de.teamLocster.storages;

import de.teamLocster.core.DBController;
import de.teamLocster.domains.GuestbookEntry;

public class GuestbookEntryRepository extends BaseRepository<GuestbookEntry> {
    public GuestbookEntryRepository() {
        super(GuestbookEntry.class, DBController.getManager().getEntityManager());
    }
}
