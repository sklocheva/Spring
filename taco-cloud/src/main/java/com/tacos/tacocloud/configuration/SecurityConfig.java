package com.tacos.tacocloud.configuration;

import com.tacos.tacocloud.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
@Configuration
@EnableWebSecurity
@ComponentScan()
// gives a plain login page
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
//    @Autowired
//    DataSource dataSource;

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder()
    {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/design", "/orders")
                .fullyAuthenticated()
                .antMatchers("/", "/**", "/h2-console/**").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design")
                .and()
                .logout()
                .logoutSuccessUrl("/");

        http.csrf().disable();
        http.headers().frameOptions().disable();

        ;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception
//    {
//
//        managerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(encoder());
//
////        // in memory auth
////        managerBuilder
////                .inMemoryAuthentication()
////                .withUser("buzz")
////                .password("infinity")
////                .authorities("ROLE_USER")
////                .and()
////                .withUser("woody")
////                .password("bullseye")
////                .authorities("ROLE_USER");
//
////        managerBuilder.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery("select username, password, enabled from Users " +
////                        "where username=?")
////                .authoritiesByUsernameQuery("select username, authority from UserAuthorities " +
////                        "where username=?")
////                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//
//    }
}
