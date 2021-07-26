package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;

import java.util.List;

public interface UserRepository extends BaseRepository<User>
{
    List<User> findByIsOnlineTrue();

    User findByEmailAddress(String emailAddress);
}
