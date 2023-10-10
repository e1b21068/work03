package oit.is.apple.work03.security;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration {
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails yamamoto = User.withUsername("yamamoto")
        .password("{bcrypt}$2y$10$oNNw8YMB.Dc.UohOwDWMlu5Kr/khHVRlMdrvhGz5M9F/T0fAUNM5i").roles("INU").build();
    UserDetails maruyama = User.withUsername("maruyama")
        .password("{bcrypt}$2y$10$g09t.Ca7.OCyfkObwC3/POOrderBHr9kWaJ2J3S09ZTA9ozU25HvO").roles("NEKO").build();

    return new InMemoryUserDetailsManager(yamamoto, maruyama);
  }

}
