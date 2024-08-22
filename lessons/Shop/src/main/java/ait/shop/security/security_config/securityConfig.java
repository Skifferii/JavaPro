package ait.shop.security.security_config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  //http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) //NASTOIKA SESII
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/products").permitAll()  // für Alle
                        .requestMatchers(HttpMethod.GET, "/products/{id}").authenticated()  // nür für Autorizirte
                        // .requestMatchers(HttpMethod.GET, "/products/{id}").hasAnyRole("ADMIN", "user")  // nür für Autorizirte
                        .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/products").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/products").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/products/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/products/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/products/{id}").permitAll()
                );

       return http.build();

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
/*
Уровни доступа!
1. Получение всех продуктов - доступно всем пользователям, включая анонимных (аутентификация не требуется)
2. Получение продукта по id - доступно только аутентифицированным пользователям с любой ролью
3. Сохранение нового продукта - доступно только администраторам. (аутентифицирован + имеет роль ADMIN)
 */