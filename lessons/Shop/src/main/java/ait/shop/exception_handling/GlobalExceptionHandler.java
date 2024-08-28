package ait.shop.exception_handling;

import ait.shop.exception_handling.exceptions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleThirdTestException(ThirdTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    //BindingResult - Pola mit OSCHIBKAMI
    // FieldError - class, predstavlayet oschibku

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException ex) {
//
//        StringBuilder errorMessage = new StringBuilder();                                          //create objekt stringBuilder dla messagev
//
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {                          // all errors
//            errorMessage.append(error.getDefaultMessage()).append(";  ");                          // add message mit error for now pole
//        }
//        Response response = new Response(errorMessage.toString());                                  //create mit massage
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();                                                    // Cоздаем список ошибок для накопления сообщений об ошибках
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {                               //перебираем все ошибки
            errors.add(error.getField() + " | " + error.getDefaultMessage());                       // Добавляем сообщение об ошибке для текущего поля
        }
        ValidationResponse response = new ValidationResponse(errors);                               //Создаем объект Response с накопленным сообщение
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);                              // Возвращаем ResponseEntity с объектом Response и статусом 400
    }


}
