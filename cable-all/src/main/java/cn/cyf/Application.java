package cn.cyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = { "cn.cyf" })
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
