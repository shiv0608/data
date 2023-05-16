package com.reglog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Bean
   public UserDetailsService getUserDetailsService()
   {
	   return new UserDetailsServiceimp();
   }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
   public DaoAuthenticationProvider authenticationProvider()
   {
	   DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	   daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
	   daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	   return daoAuthenticationProvider;
   }
   
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	
		// http.authorizeRequests().antMatchers("/register/**").hasRole("/index").antMatchers("/users").hasRole("ADMIN")
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/register/**").permitAll()
									.antMatchers("/users").hasRole("ADMIN")
									.antMatchers("/index").permitAll()
					.and().formLogin().loginPage("/login")
					.loginProcessingUrl("/login").defaultSuccessUrl("/user")
					.permitAll().and().logout();
					

		}	
	 
	}

	/*public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
                authorize.antMatchers("/register/**").permitAll()
                        .antMatchers("/index").permitAll()
                        .antMatchers("/users").hasRole("ADMIN")
        ).formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/users")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );*/



	  
   
