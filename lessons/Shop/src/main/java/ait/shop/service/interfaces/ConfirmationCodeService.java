package ait.shop.service.interfaces;


import ait.shop.model.entity.ConfirmationCode;
import ait.shop.model.entity.User;

import java.util.Optional;

public interface ConfirmationCodeService {

    // Метод для генерации кода подтверждения
    String generationConfirmationCode(User user);
    Optional<ConfirmationCode> findCodeByUser(User user);
    void remove(ConfirmationCode code);
    Optional<ConfirmationCode> findByCode(String code);
}