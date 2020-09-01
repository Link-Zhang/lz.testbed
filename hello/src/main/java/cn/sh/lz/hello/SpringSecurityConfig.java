package cn.sh.lz.hello;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/***
 * @author Link
 * @date 2020/05/13
 * @time 17:24
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${server.port}")
    private int serverPort;

    private RequestMatcher forPort(final int port) {
        return (HttpServletRequest request) -> port == request.getLocalPort();
    }

    private RequestMatcher forPortAndPath(final int port, @NonNull final String pattern) {
        return new AndRequestMatcher(forPort(port), new AntPathRequestMatcher(pattern));
    }

    private RequestMatcher forPortAndPath(final int port, @NonNull final HttpMethod method, @NonNull final String pattern) {
        return new AndRequestMatcher(forPort(port), new AntPathRequestMatcher(pattern, method.name()));
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(forPortAndPath(serverPort, "/management")).hasRole("ADMIN")
                        .requestMatchers(forPortAndPath(serverPort, "/swagger-ui.html")).hasRole("ADMIN")
                        .requestMatchers(forPortAndPath(serverPort, HttpMethod.GET, "/hello/greeting")).hasRole("USER")
                        .requestMatchers(forPortAndPath(serverPort, HttpMethod.GET, "/hello/**")).permitAll()
                        .anyRequest().permitAll()
        ).formLogin(Customizer.withDefaults());
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("user").password(passwordEncoder.encode("123456")).roles("USER").build();
        inMemoryUserDetailsManager.createUser(userDetails);
        userDetails = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build();
        inMemoryUserDetailsManager.createUser(userDetails);
        return inMemoryUserDetailsManager;
    }
}
