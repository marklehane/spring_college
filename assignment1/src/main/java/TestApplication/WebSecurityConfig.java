package TestApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	        .antMatchers("/**","/artist/").permitAll() // #4
	        .anyRequest().authenticated() // 7
	        .and()
	    .formLogin()  // #8
	       .loginPage("/login") // #9
	        .permitAll().and().logout().logoutUrl("/logout");
	  }
    
public static DriverManagerDataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost/assignment1");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    return dataSource;
}
    
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()                
        .dataSource(getDataSource())                
        .usersByUsernameQuery("select username as principal, password,enabled as credentials from users where username = ?")
        
; 
    }
}