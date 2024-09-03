package ait.shop.repository;
import ait.shop.model.entity.ConfirmationCode;
import ait.shop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {
    // Метод для поиска кода по его значению
    Optional<ConfirmationCode> findByCode(String code);
    Optional<ConfirmationCode> findCodeByUser(User user);
}