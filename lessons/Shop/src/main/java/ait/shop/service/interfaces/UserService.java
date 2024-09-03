package ait.shop.service.interfaces;

import ait.shop.model.dto.UserRegisterDto;

public interface UserService {

    void register(UserRegisterDto registerDto);
    String confirmationMailByCode(String code);
}