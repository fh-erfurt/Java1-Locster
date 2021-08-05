package de.teamLocster.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LocsterUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    /*
    @Autowired
    public LocsterUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> data = userRepository.findByEmailAddress(username);
        if(data.isPresent()) return new LocsterUserDetails(data.get());
        throw new UsernameNotFoundException("No user with this email address was found in the database!");
    }
}
