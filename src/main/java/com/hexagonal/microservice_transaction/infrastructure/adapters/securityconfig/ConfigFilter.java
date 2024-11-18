package com.hexagonal.microservice_transaction.infrastructure.adapters.securityconfig;

import com.hexagonal.microservice_transaction.infrastructure.adapters.jwtconfiguration.JwtAuthenticationFilter;
import com.hexagonal.microservice_transaction.infrastructure.adapters.jwtentrypoint.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static com.hexagonal.microservice_transaction.constants.ValidationConstants.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private static final String HTTP = "http://localhost:4200";
    private static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE"};
    private static final String[] ALL_HEADERS = {"Content-Type", "Authorization"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(java.util.List.of(HTTP));
                    config.setAllowedMethods(java.util.List.of(ALLOWED_METHODS));
                    config.setAllowedHeaders(java.util.List.of(ALL_HEADERS));
                    config.setAllowCredentials(true);
                    return config;
                }))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(V3_API).permitAll()
                        .requestMatchers(AUTH).permitAll()
                        .requestMatchers(SWAGGER_UI).permitAll()
                        .requestMatchers(SWAGGER_UI_RESOURCES).permitAll()
                        .requestMatchers(ALL_API).authenticated()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
    }
}