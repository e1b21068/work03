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
  //@Bean
  // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  //   http.formLogin(login -> login
  //       .permitAll())
  //       .logout(logout -> logout
  //           .logoutUrl("/logout")
  //           .logoutSuccessUrl("/"))
  //       .authorizeHttpRequests(authz -> authz
  //           .requestMatchers(AntPathRequestMatcher.antMatcher("/sample3/**")).authenticated()
  //           .requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll());
  //   return http.build();
  //}

  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails yamamoto = User.withUsername("yamamoto")
        .password(/* "{bcrypt}$2y$10$UhlrsAP5QuA24Qo7up5TrerqIMD6kq/d19HlqIcp.iO03y3DcSa3O" */"{noop}yama").roles("INU")
        .build();
    UserDetails maruyama = User.withUsername("maruyama")
        .password("{bcrypt}$2y$10$g09t.Ca7.OCyfkObwC3/POOrderBHr9kWaJ2J3S09ZTA9ozU25HvO").roles("NEKO").build();

    return new InMemoryUserDetailsManager(yamamoto, maruyama);
  }

}
