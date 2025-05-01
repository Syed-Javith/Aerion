package com.rsj.aerion.config;

import com.rsj.aerion.usermgmt.services.UserMgmtService;
import com.rsj.aerion.web.filters.JwtFilter;
import com.rsj.aerion.web.filters.SecurityFilter;
import com.rsj.aerion.web.interceptors.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

@Configuration
@EnableWebMvc
public class WebMVCConfiguration implements WebMvcConfigurer {

    private static final String[] PUBLIC_URLS = { "api/auth/login", "api/auth/register", "api/auth/logout" };

    @Autowired
    UserMgmtService userMgmtService;
    @Autowired
    private JwtFilter jwtFilter;
    //@Autowired
    //private SecurityFilter securityFilter;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry
                .addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(PUBLIC_URLS);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                        request ->
                                request
                                        .requestMatchers(PUBLIC_URLS).permitAll()
                                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        sessionManagement ->
                                sessionManagement
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                //.addFilterBefore(securityFilter, JwtFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider
                .setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(userMgmtService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // your frontend origin
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true); // allows sending cookies/session

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean("configMap")
    public Map<String, String> configMap() {
        return Map.of("dc.url", "http://localhost:8080");
    }
}
