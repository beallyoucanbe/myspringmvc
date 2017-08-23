package spittr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by zhaosy-c on 2017/7/28.
 */

@Configuration
@ComponentScan(basePackages = {"spittr"})
public class RootConfig {

}
