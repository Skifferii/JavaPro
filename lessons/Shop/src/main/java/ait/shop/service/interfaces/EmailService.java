package ait.shop.service.interfaces;


import ait.shop.model.entity.User;

public interface EmailService {
    //Метод для отправки email пользователю
    void sendConfirmationEmail(User user);
}