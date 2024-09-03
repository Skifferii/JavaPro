package ait.shop.model.dto;

import java.util.Objects;

public record UserRegisterDto(String username, String password, String email) {
}