package com.capitole.zara;


import com.capitole.zara.config.aop.GeneralAspect;
import com.capitole.zara.dto.response.PriceResponse;
import com.capitole.zara.exception.GeneralAspectException;
import com.capitole.zara.exception.NoPriceExistException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class AspectTests {

    @InjectMocks
    GeneralAspect generalAspect;

    @Mock
    private ProceedingJoinPoint joinPoint;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void aspectTest()  {

        Object[] aux = new Object[1];
        aux[0] = 1;
        Mockito.when(joinPoint.getArgs()).thenReturn(aux);

        generalAspect.validateParameters(joinPoint);

    }

    @Test
    void aspect0Test()  {

        Object[] aux = new Object[1];
        aux[0] = 0;
        Mockito.when(joinPoint.getArgs()).thenReturn(aux);

        Assertions.assertThrows(GeneralAspectException.class,
                () -> {
                    generalAspect.validateParameters(joinPoint);
                });
    }

    @Test
    void aspectNullArgTest()  {
        Mockito.when(joinPoint.getArgs()).thenReturn(null);
        generalAspect.validateParameters(joinPoint);

    }


}
