package beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by oleksiiprokopenko on 13/11/2017.
 */
@Configuration
@ComponentScan({ "beans" })
//@EnableAspectJAutoProxy
public class ServiceConfig {

}
