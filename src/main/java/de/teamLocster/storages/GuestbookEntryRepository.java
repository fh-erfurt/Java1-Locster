package de.teamLocster.storages;

import de.teamLocster.domains.GuestbookEntry;

public class GuestbookEntryRepository extends BaseRepository<GuestbookEntry> {
    public GuestbookEntryRepository() {
        super(GuestbookEntry.class, H2Controller.getManager().getEntityManager());
    }
}
