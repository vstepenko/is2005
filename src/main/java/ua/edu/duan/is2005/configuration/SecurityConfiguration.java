package ua.edu.duan.is2005.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails tom = User.builder()
                .username("tom")
                .password("{noop}1234")
                .roles("TEACHER")
                .build();

        UserDetails gatto = User.builder()
                .username("gatto")
                .password("{noop}1")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(tom, gatto);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> {
                    configurer.requestMatchers(HttpMethod.GET, "/").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.GET, "/swagger-ui/**").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.GET, "/v3/api-docs").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.GET, "/students").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.GET, "/student/**").hasAnyRole("TEACHER", "MANAGER");
                    configurer.requestMatchers(HttpMethod.POST, "/student").hasAnyRole("MANAGER");
                    configurer.requestMatchers(HttpMethod.PUT, "/student").hasAnyRole("MANAGER");
                    configurer.requestMatchers(HttpMethod.DELETE, "/student").hasAnyRole("MANAGER");
                }
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
