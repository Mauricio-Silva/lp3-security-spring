package br.com.ifms.tads5.lp3securityspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .inMemoryAuthentication()
        .withUser("artista")
        .password("123")
        .roles("USER")
        .and()
        .withUser("supervisor")
        .password("456")
        .roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // http
        // .authorizeHttpRequests()
        // .antMatchers("/")
        // .permitAll()
        // .and()
        // .httpBasic()
        // .and()
        // .authorizeRequests()
        // .antMatchers("/message**")
        // .hasRole("ADMIN")
        // .and()
        // .authorizeRequests()
        // .antMatchers("/admin**")
        // .hasRole("ADMIN");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
