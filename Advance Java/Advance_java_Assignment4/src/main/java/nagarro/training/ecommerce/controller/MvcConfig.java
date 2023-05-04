package nagarro.training.ecommerce.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("nagarro.training.ecommerce.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {

}
