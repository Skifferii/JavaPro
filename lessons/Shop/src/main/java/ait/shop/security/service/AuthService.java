package ait.shop.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserDetailsService userService;
private final TokenService tokenService;
private final BCryptPasswordEncoder passwordEncoder;
// username : token
private final Map<String, String> refreshStorage;

    public AuthService(UserDetailsService userService, TokenService tokenService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.refreshStorage = new HashMap<>();
    }

    public TokenResponseDto login (TokenResponseDto)
    /*
    1prinat data
    2 proverka login password
    3 generate token
    4 save token in repo
    5 komb antwort
     */
}
