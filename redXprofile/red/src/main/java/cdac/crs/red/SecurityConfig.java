package cdac.crs.red;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	private static final Logger logger = Logger.getLogger(SecurityConfig.class.getName());

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests(authorize -> authorize.antMatchers("/hello", "/authenticate_user").permitAll() // Allow access to /hello
//																						// without authentication
//				.anyRequest().authenticated() // Require authentication for all other requests
//		).formLogin(form -> form.permitAll() // Allow everyone to access the login page
//		).logout(logout -> logout.permitAll() // Allow everyone to access the logout page
//		);
//
//		return http.build();
//	}

	@Bean
	public OncePerRequestFilter loggingFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
				logger.info("Incoming request: " + request.getMethod() + " " + request.getRequestURI());
				Enumeration<String> parameterNames = request.getParameterNames();
				while (parameterNames.hasMoreElements()) {
					String paramName = parameterNames.nextElement();
					String paramValue = request.getParameter(paramName);
					logger.info("Parameter: " + paramName + " = " + paramValue);
				}
				filterChain.doFilter(request, response);
			}
		};
	}
}
