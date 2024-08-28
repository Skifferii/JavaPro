package ait.shop.ligging;

import ait.shop.model.dto.ProductDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.saveProduct(..))")
    public void saveProduct() {
        //method nur fur PoinCur
    }

    @Before("saveProduct()")
    public void beforeSavingProduct(JoinPoint joinPoint) {
        //unrar parametrs
        Object [] params = joinPoint.getArgs();

        logger.info("Method save in class ProductServiceImp was called with parameter: {}", params[0]);
    }

    @After("saveProduct()")
    public void afterSavingProduct(JoinPoint joinPoint) {
        //unrar parameters
        Object [] params = joinPoint.getArgs();
        logger.info("Method save in class ProductServiceImp finished its work with parameter: {}", params[0]);
    }


    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.getById(..))")
    public void getProductById() {}

    @AfterReturning(pointcut = "getProductById()", returning = "result")
    public void afterReturnFromGetById(Object result) {
        logger.info("Method getById successfully return result: {}", result);
    }


    @AfterThrowing(pointcut = "execution(* ait.shop.service.ProductServiceImpl.getById(..))", throwing = "ex")
    public void  afterThrowingExceptionFromGetById (JoinPoint joinPoint, Exception ex) {
        Object [] params = joinPoint.getArgs();
        logger.info("Method getById with param {} throw ex: {}", params[0], ex.getMessage());
    }


    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.getAll(..))")
    public void getAllProducts() {}

    @Around("getAllProducts()")
    public Object aroundGetAllProducts(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {// log before
            logger.info("Method GetAllProducts called");

            //do method
            result = joinPoint.proceed();

            //Logg after super und comm
            logger.info("Method GetAllProducts successfully returned result: {}", result);


            //i want change result +
            result = ((List<ProductDTO>) result).stream().filter(product -> product.getPrice().doubleValue() > 0).toList();
        } catch (Throwable ex) {
            logger.error("Method GetAllProducts failed", ex.getMessage());
        }
        return result == null ? new ArrayList<>() : result;

    }



}
