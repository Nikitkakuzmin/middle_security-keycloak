package kz.nik.middle.middlesecurity.config;


import kz.nik.middle.middlesecurity.beans.SomeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public SomeBean someBean(){
        return new SomeBean();
    }

}