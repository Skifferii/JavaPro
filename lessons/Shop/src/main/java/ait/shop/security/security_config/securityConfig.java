package ait.shop.security.security_config;


import ait.shop.security.filter.TokenFilter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class securityConfig {

    public securityConfig(TokenFilter tokenFilter) {
        this.tokenFilter = tokenFilter;
    }

    private  final TokenFilter  tokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // настройка сессий
                .httpBasic(AbstractHttpConfigurer::disable) // отключаем базовую аутентификацию
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
//                                .anyRequest().permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs").permitAll()
                                .requestMatchers(HttpMethod.GET, "/products").permitAll() // разрешено всем
                                .requestMatchers(HttpMethod.GET, "/products/{id}").authenticated() //  только для аутентифицированных пользователей
//                        .requestMatchers(HttpMethod.GET, "/products/{id}").hasAnyRole("ADMIN", "USER") //  только для пользователей с ролью USER или ADMIN
                                .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                                .anyRequest().authenticated()
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