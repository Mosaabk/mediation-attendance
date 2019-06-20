package com.waa.dragons.mediationattendance.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll();
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .authorizeRequests()
                    .antMatchers("/student/**").hasAuthority("STUDENT")
                    .antMatchers("/admin/**").hasAuthority("ADMIN")
                    .antMatchers("/faculty/**").hasAuthority("FACULTY")
                    .and()
                .formLogin()
                    .loginPage("/login").successHandler(myAuthenticationSuccessHandler()).failureUrl("/login-error");

    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.
                inMemoryAuthentication()
                    .withUser("admin").password(encoder.encode("123")).authorities("ADMIN","STUDENT")
                    .and()
                    .withUser("987174").password(encoder.encode("123")).authorities("STUDENT")
                    .and()
                    .withUser("091043").password(encoder.encode("123")).authorities("STUDENT")
                    .and()
                    .withUser("986984").password(encoder.encode("123")).authorities("STUDENT")
                    .and()
                    .withUser("986899").password(encoder.encode("123")).authorities("STUDENT")
                    .and()
                    .withUser("tina").password(encoder.encode("123")).authorities("FACULTY", "ADMIN")
                    .and()
                    .withUser("jbruen").password(encoder.encode("123")).authorities("FACULTY")
                    .and()
                    .withUser("renuka").password(encoder.encode("123")).authorities("FACULTY");


    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**");
    }

}
