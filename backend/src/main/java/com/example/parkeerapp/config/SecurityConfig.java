package com.example.parkeerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder passwordEncoder;

    @Qualifier("UserUserDetailService")
    @Autowired
    public void setMemberDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    //basic http security & alleen authenticated requests worden authorized, moet nog aangepast worden.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().cors()
                .and()
                .authorizeRequests()
                .antMatchers("http://localhost:3000/Login").permitAll()
                .and()
                .formLogin()
                .loginPage("http://localhost:3000/Login").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();

        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

        auth.inMemoryAuthentication()
                .withUser("member").password(passwordEncoder.encode("member")).roles("MEMBER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("MEMBER","ADMIN");
    }

}