package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Tomasz Dębski
 *
 */
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@PropertySource("classpath:application.properties")
public class SecurityConfiguration /* extends WebSecurityConfigurerAdapter*/ {
	
//	@Autowired
//	Environment env;
//	
//	@Autowired
//	DataSource dataSource;
//
//	 @Autowired
//	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//	        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
////	        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
////	        auth.authenticationProvider(CustomAuthenticationProvider);
////		 	auth.userDetailsService(userDetailsService);
//
////	        auth
////	        .jdbcAuthentication().dataSource(dataSource)
////			.usersByUsernameQuery(
////				"select name,password,'true' as enabled from myuser where name=?")
////			.authoritiesByUsernameQuery(
////				"select name, role from myuser where name=?")
////				.passwordEncoder(passwordEncoder())
////				;
//	    }
//	     
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	       
//	      http
//	      .authorizeRequests()
//		      	.antMatchers("/","/index").permitAll()
//		        .antMatchers("/logList").authenticated()
//		        .antMatchers("/addUser","/adminPanel")
//		        .access("hasRole('ROLE_ADMIN')")
//	        .and()
//		        .formLogin()
//		        .loginPage("/loginPage")
//		        .loginProcessingUrl("/j_spring_security_check").failureUrl("/loginPage?error=true")
//		        .usernameParameter("username").passwordParameter("password")
//		        .defaultSuccessUrl("/")
//	        .and()
//	        	.exceptionHandling().accessDeniedPage("/Access_Denied")
////	        .and()
////		        .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
////		        .csrf().csrfTokenRepository(csrfTokenRepository())
//		        ;
//	    }
	    
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	    
//	    private CsrfTokenRepository csrfTokenRepository() {
//			HttpSessionCsrfTokenRepository repository = 
//					new HttpSessionCsrfTokenRepository();
//			repository.setHeaderName("X-XSRF-TOKEN");
//			return repository;
//		}
}
