package com.boco.jlappservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@ConditionalOnClass({WebSecurityConfigurerAdapter.class})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${spring.security.user.name:boco}")
    private String userName;
    @Value("${spring.security.user.password:rnop123}")
    private String password;

    public WebSecurityConfig() {
    }

    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)http.csrf().disable()).authorizeRequests().antMatchers(new String[]{"/swagger-ui.html"})).authenticated().antMatchers(new String[]{"/druid/**"})).authenticated().and()).authorizeRequests().antMatchers(new String[]{"/**"})).permitAll().and()).httpBasic().and()).formLogin();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        ((InMemoryUserDetailsManagerConfigurer)auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())).withUser(this.userName).password(this.password).roles(new String[]{"USER"});
    }
}
