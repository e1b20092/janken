package oit.is.z1406.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserBuilder users = User.builder();

    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$X8SOWHE3u2oHRoRfxYFeJe/aUkLGprQhKF/uBdnJ0H.C8wl2gjFxG")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$IIpjHXYKBvhprEMCGrPDv.aQmVGXLLYRNXtFW9QhFODJB73JjmqM6")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("ほんだ")
        .password("$2y$10$zv2IW4dALWiZar/raQidC.Hj.LHA6t9yNkh7tMpSj8Ne3IJCcOGCi")
        .roles("USER")
        .build();
    UserDetails user4 = users
        .username("いがき")
        .password("$2y$10$Ef0O3QHIf59rZhsxh4lxYe5S13J0zg3l521lWG/MbCMBk6QuXvB0u")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user1, user2, user3, user4);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/janken/**").authenticated();

    http.logout().logoutSuccessUrl("/");
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
