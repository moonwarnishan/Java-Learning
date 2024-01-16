package com.example.crudDemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource)
    {
        //Execute this into Db
       /* USE `employee_directory`;

        DROP TABLE IF EXISTS `authorities`;
        DROP TABLE IF EXISTS `users`;

        --
                -- Table structure for table `users`
        --

                CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
            PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

        --
                -- Inserting data for table `users`
        --
                -- NOTE: The passwords are encrypted using BCrypt
        --
                -- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
    --
            -- Default passwords here are: fun123
            --

        INSERT INTO `users`
        VALUES
                ('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
                ('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
        ('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


        --
                -- Table structure for table `authorities`
        --

                CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
        UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
        CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

        --
                -- Inserting data for table `authorities`
        --

                INSERT INTO `authorities`
        VALUES
                ('john','ROLE_EMPLOYEE'),
                ('mary','ROLE_EMPLOYEE'),
        ('mary','ROLE_MANAGER'),
        ('susan','ROLE_EMPLOYEE'),
        ('susan','ROLE_MANAGER'),
        ('susan','ROLE_ADMIN');*/
        return new JdbcUserDetailsManager(datasource);
    }
    //We Can Also Use Custom user role table. Here is the code
   /* @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        theUserDetailsManager
                .setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return theUserDetailsManager;
    }*/


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")

        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless Rest APIs that use POST, PUT, DELETE and/or PATCH
    http.csrf(csrf -> csrf.disable());
    return http.build();
    }
}
