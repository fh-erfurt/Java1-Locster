package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.enums.OnlineStatus;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    List<User> findByIsOnlineTrueAndOnlineStatus(OnlineStatus onlineStatus);

    Optional<User> findByEmailAddress(String emailAddress);

    @Query("select u from User u where u.firstName like %?1% or u.lastName like %?1% or u.region like %?1%")
    List<User> findAllByKey(String query);

}
