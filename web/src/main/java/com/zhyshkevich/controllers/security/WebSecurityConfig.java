package com.zhyshkevich.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Created by Сергей on 01.06.2017.
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    private UserDetailsService userDetailsService;
    private LogoutSuccessHandler logoutSuccessHandler;
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public WebSecurityConfig(
            AuthenticationEntryPoint authenticationEntryPoint,
            UserDetailsService userDetailsService,
            LogoutSuccessHandler logoutSuccessHandler
    ) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.userDetailsService = userDetailsService;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login/*").permitAll()
                .antMatchers("/register").permitAll()

                //.antMatchers("/register").permitAll()

                .antMatchers(
                        "/foods/**"
                ).hasRole("user")

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()


                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()


                .csrf()
                .disable();

//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .usernameParameter("client_email") //мб поменяй как в дто
//                .and()
//                .logout()
//                .and()
//                .csrf()
//                .disable();
    }
}
