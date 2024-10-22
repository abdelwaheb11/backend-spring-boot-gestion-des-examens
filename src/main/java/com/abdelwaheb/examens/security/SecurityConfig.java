package com.abdelwaheb.examens.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;



import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.sessionManagement( session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf( csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(new CorsConfigurationSource()
            {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cors = new CorsConfiguration();

                cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                cors.setAllowedMethods(Collections.singletonList("*"));
                cors.setAllowedHeaders(Collections.singletonList("*"));
                cors.setExposedHeaders(Collections.singletonList("Authorization"));
                return cors;
                }
            }))
            .authorizeHttpRequests( requests ->requests
            //examen request -----------------------
            .requestMatchers( HttpMethod.GET ,"/api/examen/all/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/examen/getAllParPage/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/examen/getById/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/examen/examenParMat/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/examen/examenParEtudiant/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.POST ,"/api/examen/save/**").hasAnyAuthority("ADMIN")
            .requestMatchers( HttpMethod.PUT ,"/api/examen/update/**").hasAnyAuthority("ADMIN")
            .requestMatchers( HttpMethod.DELETE ,"/api/examen/delete/**").hasAnyAuthority("ADMIN")
            //matiere request --------------------------
            .requestMatchers( HttpMethod.GET ,"/api/matieres/all/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/matieres/getById/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.GET ,"/api/matieres/matieresParLabelle/**").hasAnyAuthority("ADMIN","USER")
            .requestMatchers( HttpMethod.POST ,"/api/matieres/save/**").hasAnyAuthority("ADMIN")
            .requestMatchers( HttpMethod.PUT ,"/api/matieres/update/**").hasAnyAuthority("ADMIN")
            .requestMatchers( HttpMethod.DELETE ,"/api/matieres/delete/**").hasAnyAuthority("ADMIN")

            .anyRequest().authenticated())
            .addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
