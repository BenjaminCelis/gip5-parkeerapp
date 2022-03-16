package com.example.parkeerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MemberDetailService MemberDetailService;
    private BCryptPasswordEncoder passwordEncoder;

    @Qualifier("MemberMemberDetailService")
    @Autowired
    public void setMemberDetailService(MemberMemberDetailService memberMemberDetailService) {
        this.MemberDetailService = BCryptPasswordEncoder;
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
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.memberDetailService(memberDetailService);

        auth.inMemoryAuthentication()
                .withUser("speler").password(passwordEncoder.encode("speler")).roles("SPELER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("SPELER","ADMIN");
    }
}
