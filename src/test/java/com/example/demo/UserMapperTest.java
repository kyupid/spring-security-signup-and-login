package com.example.demo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserMapperTest {

    @Autowired
    DefaultListableBeanFactory df;

    @Test
    @DisplayName("bean조회")
    void updateAuthKey() {
        for(String name: df.getBeanDefinitionNames()) {
            System.out.println(name + " \t" + df.getBean(name).getClass().getName());
        }
    }
}
