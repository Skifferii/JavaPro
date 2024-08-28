package ait.shop.controller;

import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Role;
import ait.shop.model.entity.User;
import ait.shop.repository.RoleRepository;
import ait.shop.repository.UserRepository;
import ait.shop.security.dto.LoginRequestDto;
import ait.shop.security.dto.TokenResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {

    @LocalServerPort
    private int port;


    private TestRestTemplate template;

    private HttpHeaders headers;

    private ProductDTO testProduct;

    private String adminAccessToken;
    private String userAccessToken;
    private String adminRefreshToken;
    private String userRefreshToken;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private static final String TEST_PRODUCT_TITLE = "Test Product";
    private static final int TEST_PRODUCT_PRICE = 777;
    private static final String TEST_ADMIN_NAME = "TestAdmin";
    private static final String TEST_USER_NAME = "TestUser";
    private static final String TEST_PASSWORD = "TestPassword";
    private static final String ROLE_ADMIN_TITLE = "ROLE_ADMIN";
    private static final String ROLE_USER_TITLE = "ROLE_USER";

    private final String URL_HOST = "http://localhost:";
    private final String AUTH_RESOURSE_NAME = "/api/auth";
    private final String PRODUCTS_RESOURSE_NAME = "/api/products";
    private final String LOGIN_ENDPOINT = "/login";

    private final String BEARER_TOKEN_PREFIX = "Bearer ";


    @BeforeEach
    public void setUp() {
        System.out.println("@BeforeEach setUp");
        template = new TestRestTemplate();
        headers = new HttpHeaders();

        // create test product
        testProduct = new ProductDTO();
        testProduct.setTitle(TEST_PRODUCT_TITLE);
        testProduct.setPrice(new BigDecimal(TEST_PRODUCT_PRICE));

        Role roleUser = null;
        Role roleAdmin;


        //try nahmen test user from DB
        User admin = userRepository.findUserByUserName(TEST_ADMIN_NAME).orElse(null);
        User user = userRepository.findUserByUserName(TEST_USER_NAME).orElse(null);

        if (admin == null) {
            //create admin
            roleAdmin = roleRepository.findByTitle(ROLE_ADMIN_TITLE).orElseThrow(() -> new RuntimeException("Role ADMIN not fount in DB"));
            roleUser = roleRepository.findByTitle(ROLE_USER_TITLE).orElseThrow(() -> new RuntimeException("Role USER not fount in DB"));

            admin = new User();
            admin.setUserName(TEST_ADMIN_NAME);
            admin.setPassword(encoder.encode(TEST_PASSWORD));
            admin.setRoles(Set.of(roleAdmin, roleUser));

            userRepository.save(admin);
        }

        if (user == null) {
            //create user
            roleUser = (roleUser != null)
                    ? roleUser
                    : roleRepository.findByTitle(ROLE_USER_TITLE).orElseThrow(() -> new RuntimeException("Role USER not fount in DB"));

            user = new User();
            user.setUserName(TEST_USER_NAME);
            user.setPassword(encoder.encode(TEST_PASSWORD));
            user.setRoles(Set.of(roleUser));

            userRepository.save(user);

        }

        // coming tokken
        //create login request dto objekt

        LoginRequestDto loginAdminDto = new LoginRequestDto(TEST_ADMIN_NAME, TEST_PASSWORD);
        LoginRequestDto loginUserDto = new LoginRequestDto(TEST_USER_NAME, TEST_PASSWORD);

        //post -> http://localhost:port/api/auth/login

        String authUrl = URL_HOST + port + AUTH_RESOURSE_NAME + LOGIN_ENDPOINT;

        HttpEntity<LoginRequestDto> request = new HttpEntity<>(loginAdminDto, headers);

        ResponseEntity<TokenResponseDto> response = template.exchange(
                authUrl,
                HttpMethod.POST,
                request,
                TokenResponseDto.class
        );
        assertTrue(response.hasBody(), "Authorisation admin response body is empty");

        //Authorization:
        TokenResponseDto tokenResponseDto = response.getBody();
        adminAccessToken = BEARER_TOKEN_PREFIX + tokenResponseDto.getAccessToken();

        // token from user
        request = new HttpEntity<>(loginUserDto, headers);
        response = template.exchange(
                authUrl,
                HttpMethod.POST,
                request,
                TokenResponseDto.class
        );
        assertTrue(response.hasBody(), "Authorisation user response body is empty");

        tokenResponseDto = response.getBody();
        userRefreshToken = BEARER_TOKEN_PREFIX + tokenResponseDto.getAccessToken();


    }


    @Test
    public void positiveGettingAllProductsWithoutAuthorization() {
        String url = URL_HOST + port + PRODUCTS_RESOURSE_NAME;
        // Void pustishka tam nih4ego net
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<List<ProductDTO>> response = template.exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                }
        );

        // Status controöe
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response has unexpectet status");
        System.out.println("STATUS " + response.getStatusCode());

        assertTrue(response.hasBody(), "Response doesnt have body");
        System.out.println(response.getBody());
    }


    @Test
    public void negativeSavingProductsWithoutAuthorization() {
        String url = URL_HOST + port + PRODUCTS_RESOURSE_NAME;
        HttpEntity<ProductDTO> request = new HttpEntity<>(testProduct, headers);

        ResponseEntity<ProductDTO> response = template.exchange(
                url,
                HttpMethod.POST,
                request,
                ProductDTO.class
        );

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode(), "Response has unexpectet status");
        System.out.println(response.getStatusCode());

        assertFalse(response.hasBody(), "Response doesnt have body");
        System.out.println(response.hasBody());
    }


}