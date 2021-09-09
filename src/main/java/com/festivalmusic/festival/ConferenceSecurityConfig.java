package com.festivalmusic.festival;

import com.festivalmusic.festival.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConferenceSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll()
                .antMatchers("/registration*").permitAll()
                .antMatchers("/assets/css/**", "assets/js/**", "/images/**").permitAll()
                .antMatchers("/index*").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .failureUrl("/login?error=true")
                .permitAll()
                .defaultSuccessUrl("/festival-news", true)

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
               // .logoutUrl("logout");

    }

@Bean
public UserDetailsService userDetailsService() {
    return new UserServiceImpl();
}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
