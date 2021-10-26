package com.huh.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("productFactoryBean")
public class ProductFactoryBean implements FactoryBean<Product> {
    @Override
    public Product getObject() throws Exception {
        return new Product();//返回的是getObject（）中说明的类型，不是创建工厂的类型
    }

    @Override
    public Class<?> getObjectType() {
        return Product.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
