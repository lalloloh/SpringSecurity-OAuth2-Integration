package br.com.laironoliveira.auth_server.api.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserStoreConfig {
    
    // Pode ser implementado consulta em um banco apenas implementado um repository que estenda a classe UserDetails
    @Bean
    UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(
            User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build()
        );

        return userDetailsManager;
    }
}
