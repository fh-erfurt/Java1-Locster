package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User>
{
    Optional<User> findByEmail(String email);

    List<User> findByIsOnlineTrue();

    User findByEmailAddress(String emailAddress);
}
