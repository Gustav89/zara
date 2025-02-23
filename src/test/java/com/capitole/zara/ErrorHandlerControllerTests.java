package com.capitole.zara;


import com.capitole.zara.controller.PricesController;
import com.capitole.zara.exception.ExceptionHandlingController;
import com.capitole.zara.exception.GeneralAspectException;
import com.capitole.zara.exception.NoPriceExistException;
import com.capitole.zara.service.IPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;


import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@WebMvcTest({PricesController.class, ExceptionHandlingController.class})
public class ErrorHandlerControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPriceService priceService;

    private final String username = "admin";
    private final String password = "03188378-52ea-41c3-9fdb-2ded4607f12f";


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getPriceTest() throws Exception {
        mockMvc.perform(get("/api/v1/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-14 00:00:00").with(httpBasic(username, password)))
                .andExpect(status().is(200));
    }



    @Test
    void getPriceExeptionTest() throws Exception {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35456;
        int brandId = 1;


        doThrow(new NoPriceExistException("El precio a aplicar no existe")).when(priceService).getPrice(applicationDate, productId, brandId);

        mockMvc.perform(get("/api/v1/prices")
                        .param("productId", "35456")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14 00:00:00").with(httpBasic(username, password)))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("El precio a aplicar no existe"));
    }


    @Test
    void getPriceGeneralAspectExceptionTest() throws Exception {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35456;
        int brandId = 0;


        doThrow(new GeneralAspectException("El valor del parametro no es valido")).when(priceService).getPrice(applicationDate, productId, brandId);

        mockMvc.perform(get("/api/v1/prices")
                        .param("productId", "35456")
                        .param("brandId", "0")
                        .param("applicationDate", "2020-06-14 00:00:00").with(httpBasic(username, password)))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("El valor del parametro no es valido"));
    }


    @Test
    void getPriceGenericExceptionTest() throws Exception {

        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,00,00,00);
        int productId = 35456;
        int brandId = 0;


        doThrow(new Exception("generic")).when(priceService).getPrice(applicationDate, productId, brandId);

        mockMvc.perform(get("/api/v1/prices")
                        .param("productId", "35456")
                        .param("brandId", "0")
                        .param("applicationDate", "2020-06-14 00:00:00").with(httpBasic(username, password)))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("generic"));
    }





}
