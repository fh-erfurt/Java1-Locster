package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.enums.OnlineStatus;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User>
{
    List<User> findByIsOnlineTrue();

    List<User> findByIsOnlineTrueAndOnlineStatusNot(OnlineStatus onlineStatus);

    Optional<User> findByEmailAddress(String emailAddress);

    List<User> findAllByFirstNameLikeOrLastNameLikeOrRegionLike(String firstName, String lastName, String region);

}
