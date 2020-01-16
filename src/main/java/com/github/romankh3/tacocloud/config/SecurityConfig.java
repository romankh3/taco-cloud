package com.github.romankh3.tacocloud.config;

import com.github.romankh3.tacocloud.service.UserDetailsService;
import com.github.romankh3.tacocloud.service.UserRepositoryUserDetailsService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

        //4.2.2 JDBC-based user store
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled from Users " +
//                                "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities " +
//                                "where username=?")
//                .passwordEncoder(new BCryptPasswordEncoder());

        //4.2.3 LDAP-based user store
//        auth
//                .ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}");

        //4.2.1 in-memory authentication
//        auth
//                .inMemoryAuthentication()
//                .withUser("buzz")
//                .password("infinity")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("woody")
//                .password("bullseye")
//                .authorities("ROLE_USER");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
}
