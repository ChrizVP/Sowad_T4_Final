package com.proyecto.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import com.proyecto.app.security.interceptow.AuthenticationTokenFilter;
import com.proyecto.app.security.security.CsrfHeaderFilter;
import com.proyecto.app.security.security.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(PasswordEncoder());
	}
	
	@Bean
	protected PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() {
		return new AuthenticationTokenFilter();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity)throws Exception{
		
		
		httpSecurity.cors();
		
		httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/resgistration").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.anyRequest().authenticated();
		
		httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
		.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		
		httpSecurity.headers().cacheControl();
		httpSecurity.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);
		
		
	}
	
	
	
}
