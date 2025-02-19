package com.capitole.zara.config.aop;


import com.capitole.zara.exception.GeneralAspectException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class GeneralAspect {
    @Before("execution(* com.capitole.zara.controller.PricesController.getFinalPrice(..))")
    public void validateParameters(JoinPoint joinPoint){

        log.info("Before method invoked::" + joinPoint.getSignature());
        if(joinPoint.getArgs() != null){
            Arrays.stream(joinPoint.getArgs()).forEach( (p) -> {
                log.info(""+p);
                if(p instanceof Integer){
                    validateIds((Integer)p);

                }
            });
        }
    }

    private void validateIds(int value){
        if(value < 1){
            throw new GeneralAspectException("El valor del parametro no es valido");
        }
    }

}
