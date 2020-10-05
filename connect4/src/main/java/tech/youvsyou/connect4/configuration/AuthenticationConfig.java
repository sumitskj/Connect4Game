package tech.youvsyou.connect4.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import tech.youvsyou.connect4.exceptions.FilterAuthenticationException;
import tech.youvsyou.connect4.service.BasicAuthProvider;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BasicAuthProvider authenticator;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticator);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().defaultsDisabled().cacheControl();
        http.logout().deleteCookies("JSESSIONID").logoutUrl("/v1/connect4/logout");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().authenticationEntryPoint(new FilterAuthenticationException());
        http
            .authorizeRequests()
            .antMatchers("/v1/connect4/register/**","/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .headers().frameOptions().disable()
            .and()
            .csrf().disable();
    }
}
