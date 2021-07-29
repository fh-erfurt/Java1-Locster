package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User>
{
    List<User> findByIsOnlineTrue();

    Optional<User> findByEmailAddress(String emailAddress);
}
