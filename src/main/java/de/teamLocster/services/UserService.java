package de.teamLocster.services;

import de.teamLocster.domains.User;
import de.teamLocster.storages.PersonalInfoRepository;
import de.teamLocster.storages.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@SpringBootApplication
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        SpringApplication.run(UserService.class);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            log.info("|----------------------|");
            log.info("|----------------------|");
            log.info("|----------------------|");
            log.info("|----Hello World!------|");
            log.info("|----------------------|");
            log.info("|----------------------|");
            log.info("|----------------------|");
        };
    }
}
