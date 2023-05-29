package com.car.rental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.car.rental.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Autowired
	private JwtAuthFilter authFilter;
	
	@Bean
	UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
    @Bean
    AuthenticationManager authenicationManagerBean(AuthenticationConfiguration configuration) throws Exception {
    	return configuration.getAuthenticationManager();
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
              .authorizeHttpRequests()
              .requestMatchers("/*").permitAll()
              .and()
//              .authorizeHttpRequests().requestMatchers("/**")
//              .authenticated()
//              .and()
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
              .authenticationProvider(authenticationProvider())
              .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
    }
//    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//      http.cors().and().csrf().disable()
//          .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//          .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//          .antMatchers("/api/test/**").permitAll()
//          .anyRequest().authenticated();
//      
//      // http....;
//      
//      return http.build();
//    }
// 
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
//    }
    
    
}
