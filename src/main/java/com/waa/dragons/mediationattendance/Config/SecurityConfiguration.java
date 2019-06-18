package com.waa.dragons.mediationattendance.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//
//        httpSecurity.authorizeRequests()
//                .antMatchers("/stu/**")
//                .hasRole("STUDENT")
//                .and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout()
//
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/access-denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("malkhatib").password("123").roles("STUDENT")
                .and()
                .withUser("tina").password("123").roles("FACULTY", "ADMIN")
                .and()
                .withUser("jbruen").password("123").roles("FACULTY");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
