package web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created by oleksiiprokopenko on 09/11/2017.
 */
public class HelloController {


    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String sayHello() {
        return "Hello now " + LocalDateTime.now().toString() + " Auditoriums:  ";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/auditoriums";
    }
}
