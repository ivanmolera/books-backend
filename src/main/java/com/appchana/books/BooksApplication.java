package com.appchana.books;

import com.appchana.books.util.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BooksApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(generateApiInfo());
	}

/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
*/

	private ApiInfo generateApiInfo()
	{
		return new ApiInfo("Books API Service", "API to manage books and all related entities", "Version 1.0 - mw",
				"urn:tos", "ivan.molera@gmail.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
/*
	@Configuration
	class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter
	{

		@Autowired
		UserRepository userRepository;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService());
			auth.authenticationProvider(authProvider());
		}

		@Bean
		UserDetailsService userDetailsService() {
			return new UserDetailsService() {

				@Override
				public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					User user = userRepository.findByUsername(username);
					if(user != null) {
						return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true,
								AuthorityUtils.createAuthorityList("USER"));
					} else {
						throw new UsernameNotFoundException("Could not find the user '" + username + "'");
					}
				}

			};
		}

		@Bean
		public DaoAuthenticationProvider authProvider() {
			DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			authProvider.setUserDetailsService(userDetailsService());
			authProvider.setPasswordEncoder(passwordEncoder());
			return authProvider;
		}
	}


	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter
	{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().fullyAuthenticated().and().
					httpBasic().and().
					csrf().disable();
		}

	}
*/
}
