package de.teamLocster.guestbook;

import de.teamLocster.core.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestbookEntryRepository extends BaseRepository<GuestbookEntry> {
    List<GuestbookEntry> findByCreatorId(Long id);

    List<GuestbookEntry> findByUserId(Long id);

}
