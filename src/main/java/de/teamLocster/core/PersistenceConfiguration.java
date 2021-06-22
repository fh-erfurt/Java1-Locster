
package de.teamLocster.core;

// import org.springdoc.data.rest.SpringDocDataRestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
// @Import(SpringDocDataRestConfiguration.class) TODO!!!
public class PersistenceConfiguration {

}