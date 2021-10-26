package com.huh;

import com.huh.spring.ApplicationContextProvider;
import com.huh.spring.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {
    private  ApplicationContextProvider applicationContextProvider;
//
    @Test
    void contextLoads() {
    }

    @Test
    public  void testFactoryBean(){

        Product productFactoryBean = (Product) applicationContextProvider.getBean("productFactoryBean");
        Product productFactoryBean1 = (Product) applicationContextProvider.getBean("productFactoryBean");

        System.out.println(productFactoryBean);
        System.out.println(productFactoryBean == productFactoryBean1);
    }
}
