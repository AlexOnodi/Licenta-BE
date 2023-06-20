package BE.licenta.Config;

import BE.licenta.Filters.JwtReqFilter;
import BE.licenta.Service.Tabela_utilizator_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    private final Tabela_utilizator_service tabela_utilizator_service;

    private final JwtReqFilter jwtReqFilter;

    @Autowired

    public SecurityConf(Tabela_utilizator_service tabela_utilizator_service, JwtReqFilter jwtReqFilter) {
        this.tabela_utilizator_service = tabela_utilizator_service;
        this.jwtReqFilter = jwtReqFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(tabela_utilizator_service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers( "/utilizator/autentificare","/utilizator/afisare", "/utilizator/stergere","/categorie/afisare","/subcategorie/afisare","/categorie/adaugare","/categorie/stergere","/subcategorie/adaugare","/produs/adaugare","/produs/actualizare","/descriere/afisare","/descriere/stergere","/produs/stergere","/favorite/adaugare","/descriere/adaugare","/autor/adaugare","/autor/afisare").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.DELETE).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors();
        http.addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
